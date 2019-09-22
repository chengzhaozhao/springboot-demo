package com.czz.springboot.ecache.service;

import com.czz.springboot.mybaits.domain.Employee;
import com.czz.springboot.mybaits.mapper.EmployeeMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;

/**
 * @author chengzhzh@datangmobile.com
 * @create 2019-09-21 12:28
 */
@Service
@Slf4j
@CacheConfig(cacheNames = "emp")
public class EmpService {
    @Autowired
    private EmployeeMapper employeeMapper;


    /**
     *
     * @param id
     * @return
     *
     * @Cacheable
     *  cacheNames/value 缓存的名称
     *  key 默认参数的值 {el}/return 值
     *  keyGenerator
     *  cacheManager/cacheResolver
     *  condition
     *  unless
     *
     *
     *  CacheAutoConfiguration
     *      CacheConfigurationImportSelector
     *             0 = "org.springframework.boot.autoconfigure.cache.GenericCacheConfiguration"
                 * 1 = "org.springframework.boot.autoconfigure.cache.JCacheCacheConfiguration"
                 * 2 = "org.springframework.boot.autoconfigure.cache.EhCacheCacheConfiguration"
                 * 3 = "org.springframework.boot.autoconfigure.cache.HazelcastCacheConfiguration"
                 * 4 = "org.springframework.boot.autoconfigure.cache.InfinispanCacheConfiguration"
                 * 5 = "org.springframework.boot.autoconfigure.cache.CouchbaseCacheConfiguration"
                 * 6 = "org.springframework.boot.autoconfigure.cache.RedisCacheConfiguration"
                 * 7 = "org.springframework.boot.autoconfigure.cache.CaffeineCacheConfiguration"
                 * 8 = "org.springframework.boot.autoconfigure.cache.SimpleCacheConfiguration"
                 * 9 = "org.springframework.boot.autoconfigure.cache.NoOpCacheConfiguration"
     *
     *
     * SimpleCacheConfiguration
     *      在容器中注册一个 ConcurrentMapCacheManager
     *          public Cache getCache(String name) {
             * 		Cache cache = this.cacheMap.get(name);
             * 		if (cache == null && this.dynamic) {
             * 			synchronized (this.cacheMap) {
             * 				cache = this.cacheMap.get(name);
             * 				if (cache == null) {
             * 					cache = createConcurrentMapCache(name);
             * 					this.cacheMap.put(name, cache);
             * 				}
             * 			}
             * 		}
             * 		return cache;
             * 	}
     *
     * 	运行流程
     * 	    1 查询缓存-cachenames from ConcurrentMapCacheManager
     * 	    2.cache 查找缓存的内容 默认的是方法的参数
     * 	    3.没有查到就查询目标对象
     * 	    4.将目标的结果放进缓存
     *
     * 	  @Cacheable 执行之前先检查缓存 有没有整个数据
     *
     *
     */
    @Cacheable(cacheNames = {"emp"})
    public Employee getEmp(Integer id){
        log.info("查询"+id+"号员工");
       return employeeMapper.getEmpById(id);
    }


    /**
     * 先调用目标方法 将目标方法缓存起来
     *
     * @param employee
     * @return
     */
    @CachePut(/*value = {"emp"},*/key = "#employee.id")
    public Employee updateEmp(Employee employee){
        log.info("update emp :"+ employee);
        employeeMapper.updateEmp(employee);
        return employee;
    }

    /**
     * allEntries = true 删除缓存中所有的数据
     * beforeInvocation = false
     * @param id
     */
    @CacheEvict(/*value = {"emp"},*/key = "#id")
    public void deleteEmp(Integer id){
        log.info("deleteEmp :"+ id);
        employeeMapper.deleteEmp(id);
    }

    @Caching(
        cacheable = {
                @Cacheable(/*cacheNames = {"emp"},*/key = "#lastName")
        },
        put = {
                @CachePut(/*cacheNames = {"emp"},*/key = "#result.id"),
                @CachePut(/*cacheNames = {"emp"},*/key = "#result.email")
        }
    )
    public Employee getEmpByLastName(String lastName){
        return employeeMapper.getEmpByLastName(lastName);
    }
}
