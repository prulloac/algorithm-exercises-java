import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Arrays;
import java.util.HashMap;

public record Input(int[] nums, int target) {
    public String toString() {
        return "Input{nums=" + Arrays.toString(nums) + ", target=" + target + "}";
    }
}

public record Output(int[] result) {
    public String toString() {
        return "Output{result=" + Arrays.toString(result) + "}";
    }
    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof Output)) return false;
        Output other = (Output) o;
        return Objects.deepEquals(result, other.result);
    }
}

public record TestCase(Input input, Output output) {
}

// solution using hashmap
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}

void main() {
    Solution solution = new Solution();
    List<TestCase> testCases = List.of(
        new TestCase(new Input(new int[]{2,7,11,15}, 9), new Output(new int[]{0,1})),
        new TestCase(new Input(new int[]{3,2,4}, 6), new Output(new int[]{1,2})),
        new TestCase(new Input(new int[]{3,3}, 6), new Output(new int[]{0,1}))
    );
    try {
        for (TestCase testCase : testCases) {
            Output result = new Output(solution.twoSum(testCase.input.nums, testCase.input.target));
            if (!Objects.deepEquals(result, testCase.output)) {
                throw new AssertionError("Error on test case: " + testCase.input + ", expected: " + testCase.output + ", but got: " + result);
            }
        }
        System.out.println("All test cases passed");    
    } catch (Throwable e) {
        System.out.println(e);
    }
}
