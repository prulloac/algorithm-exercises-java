import java.util.List;
import java.util.Map;
import java.util.HashMap;

public record Input(int[] nums, int target) {
    public Input {
        assert nums.length >= 2;
    }
}
public record Output(int[] result) {
    public Output {
        assert result.length == 2;
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
            int[] result = solution.twoSum(testCase.input.nums, testCase.input.target);
            assert testCase.output.result[0] == result[0];
            assert testCase.output.result[1] == result[1];
        }
        System.out.println("All test cases passed");    
    } catch (AssertionError | IllegalArgumentException e) {
        System.out.println(e);
    }
}
