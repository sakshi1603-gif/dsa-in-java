// LU: Hashmap 3_ Insert Delete GetRandom O(1)-Duplicates
// Success rate: 15.79%
// You need to implement the RandomizedCollection class, which represents a collection of numbers that can contain duplicates (i.e., a multiset). The class should support insertion, removal of specific elements, and reporting a random element. The methods should run in average O(1) time complexity.

// Class Methods:
// RandomizedCollection(): Initializes an empty RandomizedCollection object.
// boolean insert(int val): Inserts an item val into the multiset. It returns true if the item was not already present, and false if it was.
// boolean remove(int val): Removes one occurrence of val from the multiset if it exists. Returns true if the item was present and removed, false otherwise.
// int getRandom(): Returns a random element from the current multiset. Each element's probability of being returned is proportional to its frequency in the multiset.

// Input Format:
// The input consists of method calls to the RandomizedCollection object, followed by the arguments for those methods.

// Output Format:
// The output should be the result of the method calls, printed in the order they are executed.

// Constraints:
// -2^31 <= val <= 2^31 - 1
// At most 2 * 105 calls in total will be made to insert, remove, and getRandom.
// There will be at least one element in the data structure when getRandom is called.