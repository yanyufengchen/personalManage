package com.person.master.conf.security;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.CachingSessionDAO;

import java.io.Serializable;

/**
 * 自定义扩展redisSession操作类
 *
 * @author ruizhao3 2019/4/23
 */

public class RedisSessionDAO extends CachingSessionDAO {
    @Override
    protected void doUpdate(Session session) {
        this.storeSession(session.getId(), session);
    }

    @Override
    protected void doDelete(Session session) {
        if (session == null) {
            throw new NullPointerException("session argument cannot be null.");
        } else {
            Serializable id = session.getId();
            if (id != null) {
                this.getActiveSessionsCache().remove(id);
            }

        }
    }

    @Override
    protected Serializable doCreate(Session session) {
        Serializable sessionId = this.generateSessionId(session);
        this.assignSessionId(session, sessionId);
        this.storeSession(sessionId, session);
        return sessionId;
    }

    private Session storeSession(Serializable sessionId, Session session) {
        if (sessionId == null) {
            throw new NullPointerException("sessionId argument cannot be null.");
        } else {
            return this.getActiveSessionsCache().put(sessionId, session);
        }
    }

    @Override
    protected Session doReadSession(Serializable sessionId) {
        return this.getCachedSession(sessionId);
    }

    /**
     * bean初始化需要执行此方法
     */
    public void init() {
        //初始化 ActiveSessionsCache
        this.setActiveSessionsCache(this.createActiveSessionsCache());
    }
}

