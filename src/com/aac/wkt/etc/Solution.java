package com.aac.wkt.etc;

public class Solution {
    public static void drawFlagX(char[][] flagPattern) {
        int height = flagPattern.length;
        int width = flagPattern[0].length;
        for (int i = 0; i < height / 2 + height % 2; i++) {
            for (int j = 0; j < width; j++) {
                if(j >= i && j <= 2*i) {
                    flagPattern[i][j] = 'X';
                    flagPattern[height - i - 1][j] = 'X';
                } else {
                    flagPattern[i][j] = ' ';
                    flagPattern[height - i - 1][j] = ' ';
                }
            }
        }
        for (int i = 0; i < height; i++) {
            for (int j = width - 1; j >= 0 ; j--) {
                if(j % 2 == 0)
                    flagPattern[i][j] = flagPattern[i][j/2];
                else
                    flagPattern[i][j] = ' ';
            }
        }
        return;
    }

    public static void drawFlagXOXO(char[][] flagPattern) {
        int height = flagPattern.length;
        int width = flagPattern[0].length;
        for (int i = 0; i < height / 2 + height % 2; i++) {
            for (int j = 0; j < width; j++) {
                if(j <= i) {
                    flagPattern[i][j] = 'X';
                    flagPattern[height - i - 1][j] = 'X';
                } else {
                    flagPattern[i][j] = ' ';
                    flagPattern[height - i - 1][j] = ' ';
                }
            }
        }
        for (int i = 0; i < height; i++) {
            for (int j = width - 1; j >= 0 ; j--) {
                if(j % 2 == 0)
                    flagPattern[i][j] = flagPattern[i][j/2];
                else if((i < height / 2 + height % 2 && j <= i * 2)||(i >= height / 2 + height % 2 && j < (height - i) * 2 - 1))
                    flagPattern[i][j] = 'O';
                else
                    flagPattern[i][j] = ' ';
            }
        }
        return;
    }

    public static void main(String[] args) {
//        Pixel pix = picture.getPixel(r,c);
//        if(c == w - 1 || r == h - 1) {
//            pix.setRed(0);
//            pix.setBlue(0);
//            pix.setGreen(0);
//            picture.setPixel(r, c, pix);
//        } else {
//            Pixel pix1 = picture.getPixel(r+1, c+1);
//            Pixel pix2 = picture.getPixel(r+1, c);
//            Pixel pix3 = picture.getPixel(r, c+1);
//            int grey0 = (pix.getRed() + pix.getBlue() + pix.getGreen()) / 3;
//            int grey1 = (pix1.getRed() + pix1.getBlue() + pix1.getGreen()) / 3;
//            int grey2 = (pix2.getRed() + pix2.getBlue() + pix2.getGreen()) / 3;
//            int grey3 = (pix3.getRed() + pix3.getBlue() + pix3.getGreen()) / 3;
//            int difference = (Math.abs(grey0-grey1) + Math.abs(grey2-grey3));
//            if(difference <= 100) {
//                pix.setRed(0);
//                pix.setBlue(0);
//                pix.setGreen(0);
//                picture.setPixel(r, c, pix);
//            } else {
//                pix.setRed(255);
//                pix.setBlue(255);
//                pix.setGreen(255);
//                picture.setPixel(r, c, pix);
//            }
//        }
        char[][] test = new char[2][24];
        new Solution().drawFlagXOXO(test);
        for (int i = 0; i < test.length; i++) {
            for (int j = 0; j < test[0].length; j++) {
                System.out.print(test[i][j]);
            }
            System.out.println();
        }
    }
}
