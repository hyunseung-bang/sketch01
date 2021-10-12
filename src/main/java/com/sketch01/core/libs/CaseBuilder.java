package com.sketch01.core.libs;

public class CaseBuilder<T> {

    private boolean latchCondition = false;

    private T result;

    public CaseBuilder<T> whenthen(int compare, T t) {
        return this.whenthen(compare == 0, t);
    }

    public CaseBuilder<T> whenthen(boolean condition, T t) {

        if( latchCondition ) {
            return this;
        }

        if( condition ){
            latchCondition = true;
            this.result    = t;
        }

        return this;
    }

    public CaseBuilder<T> elsethen(T t) {

        if( !latchCondition ){
            this.result = t;
        }

        return this;
    }

    public T end(){
        return result;
    }

}
