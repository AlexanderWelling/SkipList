package com.company;

public class SkipElement<T extends Comparable<T>> {
    final private T value;
    private SkipElement<T> next;
    private SkipElement<T> nextLevel;

    public SkipElement(T value, SkipElement<T> next, SkipElement<T> nextLevel)
    {
        this.value = value;
        this.next = next;
        this.nextLevel = nextLevel;
    }

    public SkipElement(T value, SkipElement<T> nextValue)
    {
        this(value, nextValue, null);
    }

    public SkipElement(T value)
    {
        this(value, null);
    }

    public SkipElement()
    {
        this(null);
    }

    public T getValue() {
        return value;
    }

    public SkipElement<T> getNext() {
        return next;
    }

    public SkipElement<T> getNextLevel() {
        return nextLevel;
    }

    public void setNext(SkipElement<T> next) {
        this.next = next;
    }

    public void setNextLevel(SkipElement<T> nextLevel) {
        this.nextLevel = nextLevel;
    }

    public boolean isSentinal()
    {
        return value == null;
    }
    @Override
    public String toString()
    {
        if(value != null)
            return value.toString();
        else return "null";
    }
}
