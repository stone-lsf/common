package com.stone.tc.common.utils;

import lombok.extern.slf4j.Slf4j;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * @author shifeng.luo
 * @version created on 2018/6/9 下午2:09
 */
@Slf4j
public class ExpressionUtil {
    private static ScriptEngineManager factory = new ScriptEngineManager();
    private static ScriptEngine engine = factory.getEngineByName("JavaScript");

    public static Double getDouble(String expression) {
        try {
            Object value = engine.eval(expression);
            return Double.parseDouble(value.toString());
        } catch (ScriptException e) {
            log.error("error expression:{}", expression, e);
            throw new RuntimeException(e);
        }
    }

    public static Float getFloat(String expression) {
        try {
            Object value = engine.eval(expression);
            return Float.parseFloat(value.toString());
        } catch (ScriptException e) {
            log.error("error expression:{}", expression, e);
            throw new RuntimeException(e);
        }
    }


    public static Short getShort(String expression) {
        try {
            Object value = engine.eval(expression);
            return Short.parseShort(value.toString());
        } catch (ScriptException e) {
            log.error("error expression:{}", expression, e);
            throw new RuntimeException(e);
        }
    }

    public static Integer getInt(String expression) {
        try {
            Object value = engine.eval(expression);
            return Integer.parseInt(value.toString());
        } catch (ScriptException e) {
            log.error("error expression:{}", expression, e);
            throw new RuntimeException(e);
        }
    }

    public static Long getLong(String expression) {
        try {
            Object value = engine.eval(expression);
            return Long.parseLong(value.toString());
        } catch (ScriptException e) {
            log.error("error expression:{}", expression, e);
            throw new RuntimeException(e);
        }
    }


    public static void main(String[] args) {
        Double value = ExpressionUtil.getDouble("3.0*5+2*10");
        System.out.println(value);

        Integer intValue = ExpressionUtil.getInt("3.0*5+2*10");
        System.out.println(intValue);
    }
}
