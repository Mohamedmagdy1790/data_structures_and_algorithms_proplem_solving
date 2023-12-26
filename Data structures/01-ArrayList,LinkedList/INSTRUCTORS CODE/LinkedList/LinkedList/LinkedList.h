#pragma once


template <class T>
class Node
{
private:
	T value;
	Node* next;

public:
	Node(T value)
	{
		this->value = value;
		next = NULL;
	}

	void SetNext(Node* n)
	{
		next = n;
	}

	Node* GetNext()
	{
		return next;
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
	
	void DeleteAll()
	{
		while(head)
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
	}

	~LinkedList()
	{
		DeleteAll();
	}

	void Add(T value)
	{
		Node<T>* n = new Node<T>(value);
		if (head)
		{
			n->SetNext(head);
			
		}
		
		head = n;
	}

	void PrintAll()
	{
		Node<T>* temp = head;
		while (temp != NULL)
		{
			cout << temp->GetValue() << " ";
			temp = temp->GetNext();
		}

		cout << endl;
	}

	void Delete(int index)
	{
		//TODO Assignment
	}
};