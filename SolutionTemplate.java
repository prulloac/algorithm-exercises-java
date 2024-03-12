import java.util.List;
import java.util.Objects;
import java.util.Arrays;

// make sure to change the Input record arguments to match the problem
public record Input(int[] nums, int target) {
    // suggested to implement toString method
    public String toString() {
        return "Input{nums=" + Arrays.toString(nums) + ", target=" + target + "}";
    }
}

// make sure to change the Output record arguments to match the problem
public record Output(int[] result) {
    // suggested to implement toString method
    public String toString() {
        return "Output{result=" + Arrays.toString(result) + "}";
    }
    // make sure to implement equals method, the following is a standard equals method
    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof Output)) return false;
        Output other = (Output) o;
        return Objects.deepEquals(result, other.result);
    }
}

// This is a standard record for test cases
public record TestCase(Input input, Output output) {
    public void run(Solution solution) {
        // this is standard, only change the method name
        Output result = new Output(solution.twoSum(input.nums, input.target));
        if (!Objects.deepEquals(result, output)) {
            throw new AssertionError("Error on test case: " + input + ", expected: " + output + ", but got: " + result);
        }
    }
}

// solution should be implemented here
class Solution {
    public int[] twoSum(int[] nums, int target) {
        return new int[]{1, 1};
    }
}

void main() {
    Solution solution = new Solution();
    List<TestCase> testCases = List.of(
        // add test cases here
        new TestCase(new Input(new int[]{1,1}, 1), new Output(new int[]{1,1}))
    );
    try {
        for (TestCase testCase : testCases) {
            testCase.run(solution);
        }
        System.out.println("All test cases passed");    
    } catch (AssertionError e) {
        System.out.println(e);
    }
}
