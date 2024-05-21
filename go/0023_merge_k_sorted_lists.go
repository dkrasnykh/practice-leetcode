package main

func merge1(list1 *ListNode, list2 *ListNode) *ListNode {
	root := &ListNode{}
	prev := root
	curr1, curr2 := list1, list2

	for curr1 != nil && curr2 != nil {
		if curr1.Val < curr2.Val {
			prev.Next = curr1
			prev = curr1
			curr1 = curr1.Next
		} else {
			prev.Next = curr2
			prev = curr2
			curr2 = curr2.Next
		}
	}

	if curr1 != nil {
		prev.Next = curr1
	}

	if curr2 != nil {
		prev.Next = curr2
	}

	return root.Next
}

func mergeKLists(lists []*ListNode) *ListNode {
	if len(lists) == 0 {
		return nil
	}
	for len(lists) > 1 {
		list1 := lists[0]
		list2 := lists[1]
		lists = lists[2:]
		newList := merge1(list1, list2)
		lists = append(lists, newList)
	}
	return lists[0]
}
