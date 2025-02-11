#pragma once
#include "ArrayList.h"

template <class T>
class Stack :
    private ArrayList<T>
{
public:
    void Push(T item)
    {
        this->Add(item);
    }

    T Pop()
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

