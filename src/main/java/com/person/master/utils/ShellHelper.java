package com.person.master.utils;

import ch.ethz.ssh2.Connection;
import ch.ethz.ssh2.Session;
import com.xiaoleilu.hutool.StrUtil;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

/**
 * ssh 工具类
 * @author jjma
 * 2019/8/29
 */
@Slf4j
public final class ShellHelper {

    private String ip;

    private int port;

    private String username;

    private String password;

    public ShellHelper(String ip, int port, String username, String password, boolean isEncrypt) {
        this.ip = ip;
        this.port = port;
        this.username = username;
        this.password = password;
        if (isEncrypt) {
            log.info("ssh passwd [{}] has been encrypt", password);
        }
    }

    /**
     * 构造函数（默认需要加密）
     *
     * @param ip
     * @param port
     * @param username
     * @param password
     */
    public ShellHelper(String ip, int port, String username, String password) {
        this(ip, port, username, password, true);
    }

    /**
     * 创建连接
     *
     * @return
     */
    private Connection getConnection() {
        final Connection conn = new Connection(ip, port);
        try {
            conn.connect();
            if (!conn.authenticateWithPassword(username, password)) {
                throw new IllegalStateException(StrUtil.format("登录服务器失败:username={},password={}", username, password));
            }
        } catch (Exception e) {
            log.error(StrUtil.format("与服务器建立连接失败:ip={}, port={}", ip, port), e);
        }
        return conn;
    }

    /**
     * 关闭连接
     *
     * @param conn 连接
     * @param sess 会话
     */
    private void closeCollection(Connection conn, Session sess) {
        if (sess != null) {
            sess.close();
        }
        if (conn != null) {
            conn.close();
        }
    }

    /**
     * 执行远程服务端命令，无返回
     *
     * @param command cmd
     */
    public void exec(String command) {
        Connection conn = null;
        Session sess = null;
        try {
            conn = getConnection();
            sess = conn.openSession();
            sess.execCommand(command);
        } catch (Exception e) {
            log.error("远程执行IP【{}】命令【{}】异常", ip, command);
        } finally {
            closeCollection(conn, sess);
        }
    }

    /**
     * 执行远程服务端命令，有返回
     *
     * @param command cmd
     * @return result
     * @throws Exception e
     */
    public String execWithResult(String command) throws Exception {
        Connection conn = null;
        Session sess = null;
        BufferedReader br = null;
        InputStreamReader is = null;
        try {
            conn = getConnection();
            sess = conn.openSession();
            sess.execCommand(command);
            is = new InputStreamReader(sess.getStdout(), Charset.defaultCharset().name());
            br = new BufferedReader(is);
            String line = null;
            final StringBuilder result = new StringBuilder();
            while ((line = br.readLine()) != null) {
                result.append(line);
            }
            return result.toString();
        } catch (Exception e) {
            log.error("远程执行IP【{}】命令【{}】异常", ip, command);
        } finally {
            if (br != null) {
                br.close();
            }
            if (is != null) {
                is.close();
            }
            closeCollection(conn, sess);
        }
        return null;
    }
}
