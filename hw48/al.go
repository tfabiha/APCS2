Team a - T. Fabiha, Jerry Ye, Nadine Jackson
APCS2 pd2
HW #48: Heap o’Trouble
2018-05-14 t

insert(elem):
	add(elem);

	while (elem != root and elem is < parent):
		switch(parent, elem);

remove(elem):
	if (elem != root):
		elem = root - 1;

		while (elem != root && elem < parent):
			switch(parent, elem);

	removeRoot();

removeRoot():
	root = last elem;
	remove(last elem);

	maintainInveriantFrom(last elem, root);

maintainInvariantFrom(child, elem):
	if (parent == elem):
		if (child < parent):
			switch(child, parent);
		return;

	maintainInvariantFrom(parent, elem);
	maintainInvariantFrom(child, parent);
