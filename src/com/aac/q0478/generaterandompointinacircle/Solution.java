package com.aac.q0478.generaterandompointinacircle;

public class Solution {

    double r;
    double x;
    double y;

    public Solution(double radius, double x_center, double y_center) {
        this.r = radius;
        this.x = x_center;
        this.y = y_center;
    }

    public double[] randPoint() {
        double theta = Math.random() * 2 * Math.PI;
        double rr = Math.sqrt(Math.random()) * r;
        double rx = this.x + rr * Math.cos(theta);
        double ry = this.y + rr * Math.sin(theta);
        return new double[] {rx, ry};
    }

    public static void main(String[] args) {
        for (double i : new Solution(2, 1, 1).randPoint()) {
            System.out.println(i);
        }
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(radius, x_center, y_center);
 * double[] param_1 = obj.randPoint();
 */
