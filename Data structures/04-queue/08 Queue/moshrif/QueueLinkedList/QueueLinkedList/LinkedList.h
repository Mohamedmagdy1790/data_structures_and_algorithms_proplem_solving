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
		if (index == 0)
		{
			Node<T>* toDelete = head;
			head = head->GetNext();
			delete toDelete;
			return;
		}

		Node<T>* temp = head;
		int count = 0;
		while (count < index && temp != NULL)
		{
			count++;
			temp = temp->GetNext();
		}

		if (!temp)
		{
			throw exception("Out of Range!");
		}

		Node<T>* toDelete = temp;

		temp->GetPrevious()->SetNext(temp->GetNext());
		temp->GetNext()->SetPrevious(temp->GetPrevious());
		delete toDelete;
	}

	void Insert(int index, T value)
	{
		Node<T>* temp = head;
		int count = 0;
		while (count < index && temp != NULL)
		{
			count++;
			temp = temp->GetNext();
		}

		if (!temp)
		{
			throw exception("Out of Range!");
		}

		Node<T>* newNode = new Node<T>(value);
		newNode->SetNext(temp);
		newNode->SetPrevious(temp->GetPrevious());
		newNode->GetPrevious()->SetNext(newNode);
		temp->SetPrevious(newNode);
	}

	//Add at head not tail
	void AddReverse(T item)
	{
		Node<T>* n = new Node<T>(item);
		if (!tail)
		{
			head = tail = n;
		}
		else
		{
			n->SetNext(head);
			head->SetPrevious(n);
			head = n;
		}
	}

	T GetHeadValue()
	{
		if (!head)
			return 0;
		return head->GetValue();
	}

	T GetTailValue()
	{
		if (!tail)
			return 0;
		return tail->GetValue();
	}

	bool IsEmpty()
	{
		return head == NULL;
	}
};
