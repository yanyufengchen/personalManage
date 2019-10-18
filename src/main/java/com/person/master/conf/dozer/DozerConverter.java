package com.person.master.conf.dozer;

import java.util.List;
import java.util.Set;

public interface DozerConverter {
    /**
     * 单个对象的深度复制及类型转换，vo/domain , po
     *
     * @param s   数据对象
     * @param clz 复制目标类型
     * @return
     */
    <T, S> T convert(S s, Class<T> clz);

    /**
     * list深度复制
     *
     * @param s   数据对象
     * @param clz 复制目标类型
     * @return
     */
    <T, S> List<T> convert(List<S> s, Class<T> clz);

    /**
     * set深度复制
     *
     * @param s   数据对象
     * @param clz 复制目标类型
     * @return
     */
    <T, S> Set<T> convert(Set<S> s, Class<T> clz);

    /**
     * 数组深度复制
     *
     * @param s   数据对象
     * @param clz 复制目标类型
     * @return
     */
    <T, S> T[] convert(S[] s, Class<T> clz);
}
