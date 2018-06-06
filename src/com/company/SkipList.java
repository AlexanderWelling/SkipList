package com.company;

import java.util.*;

public class SkipList<T extends Comparable<T>> implements List<T>{
    final static double PROBABILITY = 0.35;
    final static int EPSILON = 2;
    private SkipElement firstSentinal;
    private SkipElement lastSentinal;
    final private double probability;
    final private int maxLevel;


    public SkipList(double probability, int maxLevel)
    {
        this.firstSentinal = new SkipElement();
        this.lastSentinal = new SkipElement();

        firstSentinal.setNext(lastSentinal);

        SkipElement currFirstSen =  this.firstSentinal;
        SkipElement currLastSen =  this.lastSentinal;
        for(int i = 1; i < maxLevel; i++)
        {
            currFirstSen.setNextLevel(new SkipElement());
            currLastSen.setNextLevel(new SkipElement());

            currFirstSen = currFirstSen.getNextLevel();
            currLastSen = currLastSen.getNextLevel();

            currFirstSen.setNext(currLastSen);
        }

        this.probability = probability;
        this.maxLevel = maxLevel;
    }

    public SkipList(int expectedElements){
        this(PROBABILITY, (int)Math.ceil(Math.log(expectedElements)/Math.log(1/PROBABILITY)) + EPSILON);
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    @Override
    public boolean add(T t) {
        SkipElement currentElement = firstSentinal;
        SkipElement [] downer = new SkipElement[this.maxLevel];
        int currentLevel = maxLevel;
        Random random = new Random();

        while(currentElement.getNextLevel() != null)
        {
            if(!currentElement.getNext().isSentinal() && currentElement.getNext().getValue().compareTo(t) < 0)
            {
                currentElement = currentElement.getNext();
            }
            else
            {
                downer[currentLevel-1] = currentElement;
                currentLevel--;
                currentElement = currentElement.getNextLevel();
            }
        }
        while(!currentElement.getNext().isSentinal() && currentElement.getNext().getValue().compareTo(t) < 0)
        {
            currentElement = currentElement.getNext();
        }
        SkipElement lastInserted = new SkipElement(t, currentElement.getNext());
        currentElement.setNext(lastInserted);

        for(int i = 1; i < downer.length; i++)
        {
            if(random.nextDouble() < PROBABILITY)
            {
                lastInserted = new SkipElement(t,downer[i].getNext(),lastInserted);
                downer[i].setNext(lastInserted);
            }
            else break;
        }

        return true;
    }

    public boolean printLevel(int level)
    {
        if(level > maxLevel || level < 0)
        {
            return false;
        }
        SkipElement currentElement = firstSentinal;
        for(int i = maxLevel; i > level ;i--)
        {
            currentElement = currentElement.getNextLevel();
        }
        currentElement = currentElement.getNext();
        System.out.print("Level " + level + " =>  ");
        while (!currentElement.isSentinal())
        {
            System.out.println(currentElement.toString());
            currentElement = currentElement.getNext();
        }
        System.out.println();
        return true;
    }

    public boolean printAllLevel()
    {
        boolean success = true;
        for(int i = 1; i < maxLevel + 1; i++)
        {
            success = printLevel(i);
        }
        return success;
    }

    @Override
    public boolean remove(Object o) {
        SkipElement currentElement = firstSentinal;
        SkipElement [] downer = new SkipElement[this.maxLevel];
        while(currentElement.getNextLevel() != null)
        {
            if(!currentElement.getNext().isSentinal() || currentElement.getNext().getValue().compareTo(o) != 0)
            {
                currentElement = currentElement.getNext();
            }
            else
            {
                currentElement = currentElement.getNextLevel();
            }
        }
        currentElement.setNext(currentElement.getNext().getNext());

        return true;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public T get(int index) {
        return null;
    }

    @Override
    public T set(int index, T element) {
        return null;
    }

    @Override
    public void add(int index, T element) {

    }

    @Override
    public T remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<T> listIterator() {
        return null;
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return null;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return null;
    }



    public T getFirst()
    {
        return null;
    }

    public T getLast()
    {
        return null;
    }
}
