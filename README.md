# CPSC-331: Assignment 4 - Hash Tables & Searching

### Project Description:
Comparing the running times of linear search, binary search, and searching a hash table on the same set of data.

###
Please note that this project operates slightly differently than the assignment description.
Under the direction of Dr. Kawash, a text files is populated with random integers to be used in the search array (this is done by the ValueGenerator class).
This way, all search values remain consistent across all tests. The IntegerFileReader class then handles generating search arrays based on these static values.
This also means that the searchArray does not to be dereferenced and repopulated each loop, which in turn means that the Hash Table only has to have values
added to it every iteration, rather than be cleared and repopulated.

###### Contributors:
 - Sloman, Calder
 - Kalin, Carlene

#### To-Do List:
- [X] Initialize the project workspace (completed by @calderslom)
- [X] Implement Sort (completed by @calderslom)
- [X] Implement Binary Search (completed by @calderslom)
- [X] Implement Hash Table population (completed by @calderslom)
- [X] Implement Hash Table Search (completed by @calderslom)
- [X] Graph runtimes of Sequential vs Binary Search (completed by @calderslom)
- [X] Graph runtimes of Binary Search vs Hash Table Lookup (completed by @calderslom)


###
- The ValueGenerator Class will create a set of 999000 values in a text file in your working directory
	- we use these to populate our searchArray
	- this way our searchArrays will always have the same values as specified in the assignment
	- JUST RUN IT ONCE AND THEN COMMENT OUT THE LINE OF CODE. THAT WAY ALL TEST RESULTS WILL REMAIN CONSISTENT.

- IntegerFileReader Class reads this text file and returns an array of ints
	- just call it and supply it with whatever size you want as an argument and it will return an array of int



