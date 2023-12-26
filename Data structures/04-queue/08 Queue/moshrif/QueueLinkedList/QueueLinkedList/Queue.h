#pragma once
#include "LinkedList.h"

template <class T>
class Queue :
    private LinkedList<T>
{
public:
    void Enqueue(T item)
    {
        this->Add(item);
    }

    T Dequeue()
    {
        T item = this->GetHeadValue();
        this->Delete(0);
        return item;
    }

    bool IsEmpty()
    {
        return LinkedList<T>::IsEmpty();
    }
};

