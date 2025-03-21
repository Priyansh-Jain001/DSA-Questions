class Solution {
    public int[] asteroidCollision(int[] asteroids) {
       Stack<Integer> stack = new Stack<>();
		int i = 0;
		while (i < asteroids.length) {
			int asteroid = asteroids[i];
			if (asteroid < 0 && !stack.isEmpty() && stack.peek() > 0) {
				if (stack.peek() + asteroid == 0) {
					stack.pop();
					i++;
				} else if (stack.peek() + asteroid > 0) {
					i++;
				} else {
					stack.pop();
				}
			} else {
				stack.push(asteroid);
				i++;
			}
		}
		int[] result = new int[stack.size()];
		int j = stack.size() - 1;
		while (!stack.isEmpty()) {
			result[j] = stack.pop();
			j--;
		}
		return result;
    }
}