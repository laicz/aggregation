/**
 * Date:     2018/5/1021:39
 * AUTHOR:   Administrator
 */
package com.zhou.springbootjpa.specs;


import org.springframework.data.jpa.domain.Specification;
import org.springframework.lang.Nullable;
import org.springframework.util.ReflectionUtils;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.Attribute;
import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.SingularAttribute;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * 用来实现自动模糊查询，对于任何实体类，如果是字符类型的就自动转换成模糊查询，其他的等值查询
 * 2018/5/10  21:39
 * created by zhoumb
 */
public class CustomerSpecs {

    public static <T> Specification<T> byAuto(final EntityManager entityManager, final T example) {
        final Class<T> type = (Class<T>) example.getClass();
        return new Specification<T>() {
            @Nullable
            @Override
            public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                EntityType<T> entity = entityManager.getMetamodel().entity(type);
                for (Attribute<T, ?> attr : entity.getDeclaredAttributes()) {
                    Object value = getValue(example, attr);
                    if (value != null) {
                        if (attr.getJavaType() == String.class) {
                            if (!StringUtils.isEmpty(value)) {
                                predicates.add(criteriaBuilder.like(root.get(attribute(entity,attr.getName(),String.class)),pattern((String) value)));
                            }else{
                                predicates.add(criteriaBuilder.equal(root.get(attribute(entity,attr.getName(),String.class)),value));
                            }
                        }
                    }
                }
                return predicates.isEmpty()? criteriaBuilder.conjunction() : criteriaBuilder.and((Predicate[]) predicates.toArray());
            }

            private <T> Object getValue(T example, Attribute<T, ?> attr) {
                return ReflectionUtils.getField((Field) attr.getJavaMember(), example);
            }

            private <E, T> SingularAttribute<T, E> attribute(EntityType<T> entity, String fieldName, Class<E> fieldClass) {
                return entity.getDeclaredSingularAttribute(fieldName, fieldClass);
            }
        };
    }
    private static String pattern(String str) {
        return "%" + str + "%";
    }


}
