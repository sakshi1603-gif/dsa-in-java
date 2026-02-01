// Peak Element
// Solution Vid:
// Youtube Link: https://youtu.be/0HqoT8GGbeU 
// Algoprep Link: https://learn.algoprep.in/s/courses/648afad5e4b08bd5923fce6e/take 
// Java Code:
class Peak_Element_Hw_remaining {
public int findPeakElement(int[] nums) {
if(nums.length == 1){
return 0;
}


if(nums[0] > nums[1]){
return 0;
}
if(nums[nums.length - 1] > nums[nums.length - 2]){
return nums.length - 1;
}


int left = 1;
int right = nums.length - 2;


while (left <= right) {
int middle = (left + right) / 2;
if(nums[middle] > nums[middle -1] && nums[middle]> nums[middle+1]){
return middle;
}


if(nums[middle] < nums[middle - 1]) {
right = middle - 1;
}else {
left = middle + 1;
}
}
return -1;
}
}
