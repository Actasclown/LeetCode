from typing import List


class Solution:
    def rob(self, nums: List[int]) -> int:
        dp = [0, 0]
        i = 0
        for num in nums:
            dp[i % 2] = max(num + dp[i % 2], dp[(i + 1) % 2])
            i = i + 1
        return dp[(i + 1) % 2]
