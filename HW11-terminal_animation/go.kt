T. Fabiha
APCS2 pd2
HW12 -- __+3R|\/|1|\|4|_  1|_|_|\|3$$__
2018-03-02

Q0: What do you make of the multiple class definitions in a single .java file?
	I knew that it was possible from glimpses of code that I've looked at
	in the interwebs. It seems that it makes easier to organize all the 
	parts of the program efficiently. It might also prevent having to go
	through extra lengths to protect a class from being accessed by 
	classes that shouldn't have access to it. I wonder what other uses it 
	has.

Q1: How are the command line arguments processed?
	If the command line arguments are given, then the main
	method defines the variables n and timeDelay with the appropriate
	arguments.

Q2: What happens if no command line arguments are given?
	The main method of the class Demo already has a hardcoded size and 
        delay time. The command line arguments just replace those.

Q3: What is the nature/purpose of the recursion? Is it necessary for the 
animation?
	The recursion calls for the next move to be placed on the board. It
	isn't necessary, but it is the simplest way to go about writing the
	code efficiently and in an easy to understand way.

Q4: What do you expect to see when you run it?
	I expect to see a matrix changing after every pass of the delay time
	where consecutive numbers are randomly placed around it until it 
	stops.

Q5: How long do you expect it to run?  
	I expect it to run for O(n*n) time delays.

Q6: What does ANSI stand for? (You are permitted some intertubes searching 
here…). What is it good for?
	ANSI stands for the character set used in Windows systems. It has the 
	same characters as the ASCII but with 128 more characters. It is used
	to control things on the terminal.

Q7: How did your expectations compare to your observations?
	I hadn't expected the probability of the items in the board already
	with non zero numbers being updated. I also hadn't expected to see 
	see the terminal actually refresh. I thought it would have just
	printed something out for every "refresh" like we saw done in class.

Q8: How might you adapt this framework to animate a probing for a Knight’s 
Tour?
	I would use a similar technique to show the board after every single
	move made, whether it be to add a knight in an empty space or to 
	remove one from an existing space. 

Knight's Tour
	1) Add a knight to an empty space.
	2) If all the spaces are occupied, then just return true.
	3) If you can place another knight though, place it.
	4) See if that knight can complete the chess board. (Ask the knight to 
	do steps 2-7.)
	5) If yes, return true.
	6) If no, and there exists another available spot to place a knight,
	   place it and go back to step 4.
	7) If no, and there exists no available spot to place a knight, then
           remove this knight and return false.
	
