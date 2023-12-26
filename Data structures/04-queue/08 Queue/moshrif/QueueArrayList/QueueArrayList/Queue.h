#pragma once
#include "ArrayList.h"

template <class T>
class Queue :
    private ArrayList<T>
{
public:
    void Enqueue(T item)
    {
        this->Insert(item, 0 );
    }

    T Dequeue()
    {
        T item = (*this)[this->GetCount() - 1];
        this->Remove(this->GetCount() - 1);
        return item;
    }

    bool IsEmpty()
    {
        return this->GetCount() == 0;
    }
};

