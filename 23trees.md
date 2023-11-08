
***insert and remove for 2-3 tree**

*insert*
insert 10 as root
insert 20, add to root node with 10
add 5, split and promote middle value so 10 is new root
5 is left child, 20 is right child
add 1, add to same node as 5 on the left
add 25, add to right of 20 in the same node
add 15, split and promote 20 and add to root with 10
middle child 15 is middle child and 25 is right child 
add 12, join same node as 15
add 13, becomes root, 10 becomes left child, 20 becomes right child
left child of 10 is 15, right child is 12
left child of 20 is 15, right child is 25 

*remove*
remove 10
swap with in order successor, smallest on left, aka, 12 
now delete node with 10 
5 swaps with 12 to be the root with 1 as left child, 12 as right child 

remove 5
root is now 13 and 20
left child is 1 and 12
middle child is 5
right child is 25 

remove 15
not a simple delete
so consider if it is a delete and borrow or a delete and steal
it has a three node to its left
so do a delete and borrow
its immediate sibling, 12, will rotate up
13 rotates down into where 15 was 

remove 13
delete and steal because it does have a three node to its left or right
make a node where 13 was into a three node
take its parent and left sibling
now you have root 20, left child 1 and 12, right child 25 
