#pragma once


template <class T>
class Node
{
private:
	T value;
	Node* next;
	Node* previous;

public:
	Node(T value)
	{
		this->value = value;
		next = previous = NULL;
	}

	void SetNext(Node* n)
	{
		next = n;
	}

	void SetPrevious(Node* n)
	{
		previous = n;
	}

	Node* GetNext()
	{
		return next;
	}

	Node* GetPrevious()
	{
		return previous;
	}

	T GetValue()
	{
		return value;
	}

	void SetValue(T val)
	{
		value = val;
	}
};

template <class T>
class LinkedList
{
private:
	Node<T>* head;
	Node<T>* tail;

	void DeleteAll()
	{
		while (head)
		{
			Node<T>* temp = head;
			head = head->GetNext();
			delete temp;
		}

		head = NULL;
	}

public:
	LinkedList()
	{
		head = NULL;
		tail = NULL;
	}

	~LinkedList()
	{
		DeleteAll();
	}

	void Add(T value)
	{
		Node<T>* n = new Node<T>(value);
		if (!head)
		{
			head = tail = n;
		}
		else
		{
			n->SetPrevious(tail);
			tail->SetNext(n);
			tail = n;
		}
	}

	void PrintAllInOrder()
	{
		Node<T>* temp = head;
		while (temp != NULL)
		{
			cout << temp->GetValue() << " ";
			temp = temp->GetNext();
		}

		cout << endl;
	}

	void PrintAllReverse()
	{
		Node<T>* temp = tail;
		while (temp != NULL)
		{
			cout << temp->GetValue() << " ";
			temp = temp->GetPrevious();
		}

		cout << endl;
	}

	void Delete(int index)
	{
		//TODO Assignment
	}

	void Insert(int index)
	{
		//TODO Assignment
	}

	//Add at head not tail
	void AddReverse(T item)
	{
		//TODO Assignment
	}
};
