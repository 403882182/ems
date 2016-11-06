
package com.jyw.model;

import java.util.ArrayList;
import java.util.List;

public class DisciplineInfoCriteria {
    /**
     * 排序字段
     */
    protected String orderByClause;

    /**
     * 过滤重复数据
     */
    protected boolean distinct;

    /**
     * 查询条件
     */
    protected List<Criteria> oredCriteria;

    /** 
     * 构造查询条件
     */
    public DisciplineInfoCriteria() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /** 
     * 设置排序字段
     * @param orderByClause 排序字段
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /** 
     * 获取排序字段
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /** 
     * 设置过滤重复数据
     * @param distinct 是否过滤重复数据
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /** 
     * 是否过滤重复数据
     */
    public boolean isDistinct() {
        return distinct;
    }

    /** 
     * 获取当前的查询条件实例
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /** 
     * 增加或者的查询条件,用于构建或者查询
     * @param criteria 过滤条件实例
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /** 
     * 创建一个新的或者查询条件
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /** 
     * 创建一个查询条件
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /** 
     * 内部构建查询条件对象
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /** 
     * 清除查询条件
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * 学科信息discipline_info的基本动态SQL对象.
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andDisciplineIdIsNull() {
            addCriterion("discipline_id is null");
            return (Criteria) this;
        }

        public Criteria andDisciplineIdIsNotNull() {
            addCriterion("discipline_id is not null");
            return (Criteria) this;
        }

        public Criteria andDisciplineIdEqualTo(Integer value) {
            addCriterion("discipline_id =", value, "disciplineId");
            return (Criteria) this;
        }

        public Criteria andDisciplineIdNotEqualTo(Integer value) {
            addCriterion("discipline_id <>", value, "disciplineId");
            return (Criteria) this;
        }

        public Criteria andDisciplineIdGreaterThan(Integer value) {
            addCriterion("discipline_id >", value, "disciplineId");
            return (Criteria) this;
        }

        public Criteria andDisciplineIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("discipline_id >=", value, "disciplineId");
            return (Criteria) this;
        }

        public Criteria andDisciplineIdLessThan(Integer value) {
            addCriterion("discipline_id <", value, "disciplineId");
            return (Criteria) this;
        }

        public Criteria andDisciplineIdLessThanOrEqualTo(Integer value) {
            addCriterion("discipline_id <=", value, "disciplineId");
            return (Criteria) this;
        }

        public Criteria andDisciplineIdIn(List<Integer> values) {
            addCriterion("discipline_id in", values, "disciplineId");
            return (Criteria) this;
        }

        public Criteria andDisciplineIdNotIn(List<Integer> values) {
            addCriterion("discipline_id not in", values, "disciplineId");
            return (Criteria) this;
        }

        public Criteria andDisciplineIdBetween(Integer value1, Integer value2) {
            addCriterion("discipline_id between", value1, value2, "disciplineId");
            return (Criteria) this;
        }

        public Criteria andDisciplineIdNotBetween(Integer value1, Integer value2) {
            addCriterion("discipline_id not between", value1, value2, "disciplineId");
            return (Criteria) this;
        }

        public Criteria andDisciplineNameIsNull() {
            addCriterion("discipline_name is null");
            return (Criteria) this;
        }

        public Criteria andDisciplineNameIsNotNull() {
            addCriterion("discipline_name is not null");
            return (Criteria) this;
        }

        public Criteria andDisciplineNameEqualTo(String value) {
            addCriterion("discipline_name =", value, "disciplineName");
            return (Criteria) this;
        }

        public Criteria andDisciplineNameNotEqualTo(String value) {
            addCriterion("discipline_name <>", value, "disciplineName");
            return (Criteria) this;
        }

        public Criteria andDisciplineNameGreaterThan(String value) {
            addCriterion("discipline_name >", value, "disciplineName");
            return (Criteria) this;
        }

        public Criteria andDisciplineNameGreaterThanOrEqualTo(String value) {
            addCriterion("discipline_name >=", value, "disciplineName");
            return (Criteria) this;
        }

        public Criteria andDisciplineNameLessThan(String value) {
            addCriterion("discipline_name <", value, "disciplineName");
            return (Criteria) this;
        }

        public Criteria andDisciplineNameLessThanOrEqualTo(String value) {
            addCriterion("discipline_name <=", value, "disciplineName");
            return (Criteria) this;
        }

        public Criteria andDisciplineNameLike(String value) {
            addCriterion("discipline_name like", value, "disciplineName");
            return (Criteria) this;
        }

        public Criteria andDisciplineNameNotLike(String value) {
            addCriterion("discipline_name not like", value, "disciplineName");
            return (Criteria) this;
        }

        public Criteria andDisciplineNameIn(List<String> values) {
            addCriterion("discipline_name in", values, "disciplineName");
            return (Criteria) this;
        }

        public Criteria andDisciplineNameNotIn(List<String> values) {
            addCriterion("discipline_name not in", values, "disciplineName");
            return (Criteria) this;
        }

        public Criteria andDisciplineNameBetween(String value1, String value2) {
            addCriterion("discipline_name between", value1, value2, "disciplineName");
            return (Criteria) this;
        }

        public Criteria andDisciplineNameNotBetween(String value1, String value2) {
            addCriterion("discipline_name not between", value1, value2, "disciplineName");
            return (Criteria) this;
        }

        public Criteria andDisciplineTuitionIsNull() {
            addCriterion("discipline_tuition is null");
            return (Criteria) this;
        }

        public Criteria andDisciplineTuitionIsNotNull() {
            addCriterion("discipline_tuition is not null");
            return (Criteria) this;
        }

        public Criteria andDisciplineTuitionEqualTo(Integer value) {
            addCriterion("discipline_tuition =", value, "disciplineTuition");
            return (Criteria) this;
        }

        public Criteria andDisciplineTuitionNotEqualTo(Integer value) {
            addCriterion("discipline_tuition <>", value, "disciplineTuition");
            return (Criteria) this;
        }

        public Criteria andDisciplineTuitionGreaterThan(Integer value) {
            addCriterion("discipline_tuition >", value, "disciplineTuition");
            return (Criteria) this;
        }

        public Criteria andDisciplineTuitionGreaterThanOrEqualTo(Integer value) {
            addCriterion("discipline_tuition >=", value, "disciplineTuition");
            return (Criteria) this;
        }

        public Criteria andDisciplineTuitionLessThan(Integer value) {
            addCriterion("discipline_tuition <", value, "disciplineTuition");
            return (Criteria) this;
        }

        public Criteria andDisciplineTuitionLessThanOrEqualTo(Integer value) {
            addCriterion("discipline_tuition <=", value, "disciplineTuition");
            return (Criteria) this;
        }

        public Criteria andDisciplineTuitionIn(List<Integer> values) {
            addCriterion("discipline_tuition in", values, "disciplineTuition");
            return (Criteria) this;
        }

        public Criteria andDisciplineTuitionNotIn(List<Integer> values) {
            addCriterion("discipline_tuition not in", values, "disciplineTuition");
            return (Criteria) this;
        }

        public Criteria andDisciplineTuitionBetween(Integer value1, Integer value2) {
            addCriterion("discipline_tuition between", value1, value2, "disciplineTuition");
            return (Criteria) this;
        }

        public Criteria andDisciplineTuitionNotBetween(Integer value1, Integer value2) {
            addCriterion("discipline_tuition not between", value1, value2, "disciplineTuition");
            return (Criteria) this;
        }

        public Criteria andDisciplineBringIsNull() {
            addCriterion("discipline_bring is null");
            return (Criteria) this;
        }

        public Criteria andDisciplineBringIsNotNull() {
            addCriterion("discipline_bring is not null");
            return (Criteria) this;
        }

        public Criteria andDisciplineBringEqualTo(Integer value) {
            addCriterion("discipline_bring =", value, "disciplineBring");
            return (Criteria) this;
        }

        public Criteria andDisciplineBringNotEqualTo(Integer value) {
            addCriterion("discipline_bring <>", value, "disciplineBring");
            return (Criteria) this;
        }

        public Criteria andDisciplineBringGreaterThan(Integer value) {
            addCriterion("discipline_bring >", value, "disciplineBring");
            return (Criteria) this;
        }

        public Criteria andDisciplineBringGreaterThanOrEqualTo(Integer value) {
            addCriterion("discipline_bring >=", value, "disciplineBring");
            return (Criteria) this;
        }

        public Criteria andDisciplineBringLessThan(Integer value) {
            addCriterion("discipline_bring <", value, "disciplineBring");
            return (Criteria) this;
        }

        public Criteria andDisciplineBringLessThanOrEqualTo(Integer value) {
            addCriterion("discipline_bring <=", value, "disciplineBring");
            return (Criteria) this;
        }

        public Criteria andDisciplineBringIn(List<Integer> values) {
            addCriterion("discipline_bring in", values, "disciplineBring");
            return (Criteria) this;
        }

        public Criteria andDisciplineBringNotIn(List<Integer> values) {
            addCriterion("discipline_bring not in", values, "disciplineBring");
            return (Criteria) this;
        }

        public Criteria andDisciplineBringBetween(Integer value1, Integer value2) {
            addCriterion("discipline_bring between", value1, value2, "disciplineBring");
            return (Criteria) this;
        }

        public Criteria andDisciplineBringNotBetween(Integer value1, Integer value2) {
            addCriterion("discipline_bring not between", value1, value2, "disciplineBring");
            return (Criteria) this;
        }

        public Criteria andDisciplineDescIsNull() {
            addCriterion("discipline_desc is null");
            return (Criteria) this;
        }

        public Criteria andDisciplineDescIsNotNull() {
            addCriterion("discipline_desc is not null");
            return (Criteria) this;
        }

        public Criteria andDisciplineDescEqualTo(String value) {
            addCriterion("discipline_desc =", value, "disciplineDesc");
            return (Criteria) this;
        }

        public Criteria andDisciplineDescNotEqualTo(String value) {
            addCriterion("discipline_desc <>", value, "disciplineDesc");
            return (Criteria) this;
        }

        public Criteria andDisciplineDescGreaterThan(String value) {
            addCriterion("discipline_desc >", value, "disciplineDesc");
            return (Criteria) this;
        }

        public Criteria andDisciplineDescGreaterThanOrEqualTo(String value) {
            addCriterion("discipline_desc >=", value, "disciplineDesc");
            return (Criteria) this;
        }

        public Criteria andDisciplineDescLessThan(String value) {
            addCriterion("discipline_desc <", value, "disciplineDesc");
            return (Criteria) this;
        }

        public Criteria andDisciplineDescLessThanOrEqualTo(String value) {
            addCriterion("discipline_desc <=", value, "disciplineDesc");
            return (Criteria) this;
        }

        public Criteria andDisciplineDescLike(String value) {
            addCriterion("discipline_desc like", value, "disciplineDesc");
            return (Criteria) this;
        }

        public Criteria andDisciplineDescNotLike(String value) {
            addCriterion("discipline_desc not like", value, "disciplineDesc");
            return (Criteria) this;
        }

        public Criteria andDisciplineDescIn(List<String> values) {
            addCriterion("discipline_desc in", values, "disciplineDesc");
            return (Criteria) this;
        }

        public Criteria andDisciplineDescNotIn(List<String> values) {
            addCriterion("discipline_desc not in", values, "disciplineDesc");
            return (Criteria) this;
        }

        public Criteria andDisciplineDescBetween(String value1, String value2) {
            addCriterion("discipline_desc between", value1, value2, "disciplineDesc");
            return (Criteria) this;
        }

        public Criteria andDisciplineDescNotBetween(String value1, String value2) {
            addCriterion("discipline_desc not between", value1, value2, "disciplineDesc");
            return (Criteria) this;
        }

        public Criteria andDisciplineIsuesdIsNull() {
            addCriterion("discipline_isuesd is null");
            return (Criteria) this;
        }

        public Criteria andDisciplineIsuesdIsNotNull() {
            addCriterion("discipline_isuesd is not null");
            return (Criteria) this;
        }

        public Criteria andDisciplineIsuesdEqualTo(String value) {
            addCriterion("discipline_isuesd =", value, "disciplineIsuesd");
            return (Criteria) this;
        }

        public Criteria andDisciplineIsuesdNotEqualTo(String value) {
            addCriterion("discipline_isuesd <>", value, "disciplineIsuesd");
            return (Criteria) this;
        }

        public Criteria andDisciplineIsuesdGreaterThan(String value) {
            addCriterion("discipline_isuesd >", value, "disciplineIsuesd");
            return (Criteria) this;
        }

        public Criteria andDisciplineIsuesdGreaterThanOrEqualTo(String value) {
            addCriterion("discipline_isuesd >=", value, "disciplineIsuesd");
            return (Criteria) this;
        }

        public Criteria andDisciplineIsuesdLessThan(String value) {
            addCriterion("discipline_isuesd <", value, "disciplineIsuesd");
            return (Criteria) this;
        }

        public Criteria andDisciplineIsuesdLessThanOrEqualTo(String value) {
            addCriterion("discipline_isuesd <=", value, "disciplineIsuesd");
            return (Criteria) this;
        }

        public Criteria andDisciplineIsuesdLike(String value) {
            addCriterion("discipline_isuesd like", value, "disciplineIsuesd");
            return (Criteria) this;
        }

        public Criteria andDisciplineIsuesdNotLike(String value) {
            addCriterion("discipline_isuesd not like", value, "disciplineIsuesd");
            return (Criteria) this;
        }

        public Criteria andDisciplineIsuesdIn(List<String> values) {
            addCriterion("discipline_isuesd in", values, "disciplineIsuesd");
            return (Criteria) this;
        }

        public Criteria andDisciplineIsuesdNotIn(List<String> values) {
            addCriterion("discipline_isuesd not in", values, "disciplineIsuesd");
            return (Criteria) this;
        }

        public Criteria andDisciplineIsuesdBetween(String value1, String value2) {
            addCriterion("discipline_isuesd between", value1, value2, "disciplineIsuesd");
            return (Criteria) this;
        }

        public Criteria andDisciplineIsuesdNotBetween(String value1, String value2) {
            addCriterion("discipline_isuesd not between", value1, value2, "disciplineIsuesd");
            return (Criteria) this;
        }
    }

    /**
     * 学科信息discipline_info的映射实体
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * 学科信息discipline_info的动态SQL对象.
     */
    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}