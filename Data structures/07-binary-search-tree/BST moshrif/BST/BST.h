#pragma once

template <class T>
class Node
{
private:
	T value;
	Node<T>* left;
	Node<T>* right;

public:
	Node(T v)
	{
		value = v;
		left = right = NULL;
	}

	void SetValue(T v)
	{
		value = v;
	}

	T GetValue()
	{
		return value;
	}

	void SetLeft(Node<T>* l)
	{
		left = l;
	}

	Node<T>* GetLeft()
	{
		return left;
	}

	void SetRight(Node<T>* r)
	{
		right = r;
	}

	Node<T>* GetRight()
	{
		return right;
	}
};

template <class T>
class BST
{
private:
	Node<T>* root;

	void DeleteTree(Node<T> * r)
	{
		if (!r)
			return;
		DeleteTree(r->GetLeft());
		DeleteTree(r->GetRight());
		delete r;
	}

	bool ExistsRInternal(T value, Node<T>* temp)
	{
		if (!temp)
			return false;
		if (temp->GetValue() == value)
			return true;
		else if (temp->GetValue() > value)
			return ExistsRInternal(value, temp->GetLeft());
		else
			return ExistsRInternal(value, temp->GetRight());
	}

public:
	BST()
	{
		root = NULL;
	}

	~BST()
	{
		if (root)
		{
			DeleteTreeR(root);
		}
	}

	bool ExistsR(T value)
	{
		return ExistsRInternal(value, root);
	}

	void Add(T value)
	{
		if (!root)
		{
			root = new Node<T>(value);
		}
		else
		{
			Node<T>* temp = root;
			Node<T>* newNode = new Node<T>(value);
			while (temp)
			{
				if (temp->GetValue() == value)
				{
					throw exception("Value already exists!");
				}
				else if (temp->GetValue() > value)
				{
					if (!temp->GetLeft())
					{
						temp->SetLeft(newNode);
						return;
					}
					else
					{
						temp = temp->GetLeft();
					}
				}
				else
				{
					if (!temp->GetRight())
					{
						temp->SetRight(newNode);
						return;
					}
					else
						temp = temp->GetRight();
				}
			}
		}
	}

	bool Exists(T value)
	{
		Node<T>* temp = root;
		while (temp)
		{
			if (temp->GetValue() == value)
			{
				return true;
			}
			else if (temp->GetValue() > value)
			{
				temp = temp->GetLeft();
			}
			else
			{
				temp = temp->GetRight();
			}
		}

		return false;
	}
};

