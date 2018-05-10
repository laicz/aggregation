/**
 * Date:     2018/5/1022:34
 * AUTHOR:   Administrator
 */
package com.zhou.springbootjpa.repository.base;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

/**
 * 2018/5/10  22:34
 * created by zhoumb
 */
@NoRepositoryBean
public interface CustomRepository<T,ID extends Serializable> extends JpaSpecificationExecutor<T> {

    Page<T> findByAuto(T example, Pageable pageable);

}
