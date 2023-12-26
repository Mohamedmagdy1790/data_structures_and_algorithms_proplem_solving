#pragma once

#include <exception>
using namespace std;

template <class T>
class ArrayList
{
private:
	T* internalMemory;
	int size;
	int currentIndex;

	void Expand()
	{
		size += 10;
		T* temp = new T[size];
		for (int i = 0; i < size - 10; i++)
		{
			temp[i] = internalMemory[i];
		}

		delete[] internalMemory;
		internalMemory = temp;
	}

public:
	ArrayList()
	{
		size = 10;
		currentIndex = 0;
		internalMemory = new T[size];
	}

	ArrayList(int size)
	{
		this->size = size;
		currentIndex = 0;
		internalMemory = new T[size];
	}

	~ArrayList()
	{
		if (internalMemory)
		{
			delete[] internalMemory;
			internalMemory = NULL;
		}
	}

	void Add(T item)
	{
		if (currentIndex >= size)
		{
			Expand();
		}

		internalMemory[currentIndex++] = item;
	}

	T& operator[](int index)
	{
		return internalMemory[index];
	}

	int GetSize()
	{
		return size;
	}

	int GetCount()
	{
		return currentIndex;
	}

	void Remove(int index)
	{
		if (index >= currentIndex)
			throw exception("Index out of range!");
		for (int i = index; i < size - 1; i++)
			internalMemory[i] = internalMemory[i + 1];
		currentIndex--;
	}


	//TODO: Assignment
	void Insert(T item, int index)
	{

	}
};

