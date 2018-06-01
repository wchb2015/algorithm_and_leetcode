package com.wchb.course2.chapter4;

/**
 * @date 5/31/18 1:45 PM
 */
public class HeapPrinter<T extends Comparable> {


    public static <T> void printHeap(MaxHeap heap) {
     /*   System.out.println("The max heap size is: " + heap.size());

        System.out.println("Data in the max heap: ");
        for (int i = 1; i < heap.size(); i++) {
            T[] data = (T[]) heap.getData();

            System.out.println(data[i]);
        }

        int n = heap.size();
        int maxLevel = 0;
        int numberPerLevel = 1;
        while (n > 0) {
            maxLevel += 1;
            n -= numberPerLevel;
            numberPerLevel *= 2;
        }

        int maxLevelNumber = (int) Math.pow(2, maxLevelNumber - 1);
        int curTreeMaxLevelNumber = maxLevelNumber;
        int index = 1;
        for (int level = 0; level < maxLevel; level++) {
            String line1 = string(max_level_number * 3 - 1, ' ');

            int cur_level_number = min(count -int(pow(2, level)) + 1,int(pow(2, level)));
            bool isLeft = true;
            for (int index_cur_level = 0; index_cur_level < cur_level_number; index++, index_cur_level++) {
                putNumberInLine(data[index], line1, index_cur_level, cur_tree_max_level_number * 3 - 1, isLeft);
                isLeft = !isLeft;
            }
            cout << line1 << endl;

            if (level == max_level - 1)
                break;

            string line2 = string(max_level_number * 3 - 1, ' ');
            for (int index_cur_level = 0; index_cur_level < cur_level_number; index_cur_level++)
                putBranchInLine(line2, index_cur_level, cur_tree_max_level_number * 3 - 1);
            cout << line2 << endl;

            cur_tree_max_level_number /= 2;
        }
*/

    }
}
