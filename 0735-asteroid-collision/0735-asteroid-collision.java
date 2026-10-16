class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for (int asteroid : asteroids) {
            boolean destroyed = false;

            // Collision happens only when stack top is moving right (>)
            // and current asteroid is moving left (<)
            while (!stack.isEmpty() && asteroid < 0 && stack.peek() > 0) {
                if (stack.peek() < -asteroid) {
                    stack.pop(); // Top asteroid explodes, keep checking the next one
                    continue;
                } else if (stack.peek() == -asteroid) {
                    stack.pop(); // Both explode
                    destroyed = true;
                    break;
                } else {
                    destroyed = true; // Current negative asteroid explodes
                    break;
                }
            }

            // If current asteroid survived all collisions, push it
            if (!destroyed) {
                stack.push(asteroid);
            }
        }

        // Convert stack to result array in correct order
        int[] result = new int[stack.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }

        return result;
    }
}
