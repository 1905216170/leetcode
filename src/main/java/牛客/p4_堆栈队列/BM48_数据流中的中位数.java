package 牛客.p4_堆栈队列;

import java.util.ArrayList;
import java.util.List;

public class BM48_数据流中的中位数 {

    List<Integer> leftBigHeapList = new ArrayList();
    List<Integer> rightSmallHeapList = new ArrayList();

    public void reBuildLeftBigTree(){
        int curIndex = 0, childIndex = curIndex * 2 + 1, maxIndex = leftBigHeapList.size() - 1;
        while (childIndex <= maxIndex){
            // 判断当前是否有右子节点
            if(childIndex + 1 <= maxIndex){
                // 比较左右子节点，取出值大的节点
                childIndex = leftBigHeapList.get(childIndex) >= leftBigHeapList.get(childIndex + 1) ? childIndex : childIndex + 1;
            }
            // 当前节点 和 最大子节点 进行比较
            if(leftBigHeapList.get(curIndex) >= leftBigHeapList.get(childIndex)){
                return;
            }
            int curVal = leftBigHeapList.get(curIndex);
            leftBigHeapList.set(curIndex, leftBigHeapList.get(childIndex));
            leftBigHeapList.set(childIndex, curVal);
            curIndex = childIndex;
            childIndex = curIndex * 2 + 1;
        }
    }

    public void reBuildRightSmallTree(){
        int curIndex = 0, childIndex = curIndex * 2 + 1, maxIndex = rightSmallHeapList.size() - 1;
        while (childIndex <= maxIndex){
            // 判断当前是否有右子节点
            if(childIndex + 1 <= maxIndex){
                // 比较左右子节点，取出值小的节点
                childIndex = rightSmallHeapList.get(childIndex) <= rightSmallHeapList.get(childIndex + 1) ? childIndex : childIndex + 1;
            }
            // 当前节点 和 最小子节点 进行比较
            if(rightSmallHeapList.get(curIndex) <= rightSmallHeapList.get(childIndex)){
                return;
            }
            // 父子节点交换
            int curVal = rightSmallHeapList.get(curIndex);
            rightSmallHeapList.set(curIndex, rightSmallHeapList.get(childIndex));
            rightSmallHeapList.set(childIndex, curVal);
            curIndex = childIndex;
            childIndex = curIndex * 2 + 1;
        }
    }

    public void addToLeftBigTree(int num){
        leftBigHeapList.add(num);
        int curIndex = leftBigHeapList.size() - 1;
        // 父节点curIndex - 1 / 2
        int parentIndex = (curIndex - 1) / 2;
        while (parentIndex >= 0){
            if(leftBigHeapList.get(curIndex) <= leftBigHeapList.get(parentIndex)){
                return;
            }
            // 父节点比当前节点小， 那么父子节点互换
            leftBigHeapList.set(curIndex, leftBigHeapList.get(parentIndex));
            leftBigHeapList.set(parentIndex, num);
            curIndex = parentIndex;
            parentIndex = (curIndex - 1) / 2;
        }
    }

    public void addToRightSmallTree(int num){
        rightSmallHeapList.add(num);
        int curIndex = rightSmallHeapList.size() - 1;
        // 父节点curIndex - 1 / 2
        int parentIndex = (curIndex - 1) / 2;
        while (parentIndex >= 0){
            if(rightSmallHeapList.get(curIndex) >= rightSmallHeapList.get(parentIndex)){
                return;
            }
            // 父节点比当前节点小， 那么父子节点互换
            rightSmallHeapList.set(curIndex, rightSmallHeapList.get(parentIndex));
            rightSmallHeapList.set(parentIndex, num);
            curIndex = parentIndex;
            parentIndex = (curIndex - 1) / 2;
        }
    }


    public void Insert(Integer num) {
        if(leftBigHeapList.size() == rightSmallHeapList.size()){
            // 两边节点数量一样，需要判断放在哪个边合理。假设num很大，比右边节点值还大，不可能把它放在左边堆，反之同理。
            if(rightSmallHeapList.size() == 0 || rightSmallHeapList.get(0) >= num){
                addToLeftBigTree(num);
            }else {
                addToRightSmallTree(num);
            }
        }else if(leftBigHeapList.size() > rightSmallHeapList.size()){
            // 当前左边大根堆 比 右边小根堆多一个节点
            if(leftBigHeapList.get(0) <= num ){
                // 当前num值比左边大根堆最大值大，那么此时num节点合情合理可以添加到右边的小根堆
                addToRightSmallTree(num);
            }else {
                // 当前num值比左边大根堆最大值小，那么需要将左边大根堆最大值（根节点）移动到右边小根堆，
                // 同时将num作为左边大根堆根节点，同时进行大根堆重建
                addToRightSmallTree(leftBigHeapList.get(0));
                leftBigHeapList.set(0, num);
                // 左边重建大根堆。
                reBuildLeftBigTree();
            }
        }else {
            // 当前左边大根堆 比 右边小根堆少一个节点
            if(rightSmallHeapList.get(0) >= num){
                // 当前num值比 右边小根堆 最小值小，那么此时num合情合理可以添加到左边的大根对
                addToLeftBigTree(num);
            }else {
                // 当前num值比右边小根堆最小值大，那么需要将右边小根堆最小值（根节点）移动到左边大根堆，
                // 同时将num作为右边大根堆根节点，同时进行小根堆重建
                addToLeftBigTree(rightSmallHeapList.get(0));
                rightSmallHeapList.set(0, num);
                reBuildRightSmallTree();
            }
        }
    }

    public Double GetMedian() {
        if(leftBigHeapList.size() == rightSmallHeapList.size()){
            if(leftBigHeapList.size() > 0){
                double val = (leftBigHeapList.get(0).intValue() + rightSmallHeapList.get(0)) / 2.0;
                return val;
            }
        }else if(leftBigHeapList.size() > rightSmallHeapList.size()){
            return (double)leftBigHeapList.get(0);
        }else {
            return (double)rightSmallHeapList.get(0);
        }
        return null;
    }

    public static void main(String[] args) {
        BM48_数据流中的中位数 test = new BM48_数据流中的中位数();
        int[] arr = {383, 886, 777, 915, 793, 335, 386, 492, 649, 421, 362, 27, 690, 59, 763, 926, 540, 426, 172, 736, 211, 368, 567, 429, 782, 530, 862, 123, 67, 135, 929, 802, 22, 58, 69, 167, 393, 456, 11, 42, 229, 373, 421, 919, 784, 537, 198, 324, 315, 370, 413, 526, 91, 980, 956, 873, 862, 170, 996, 281, 305, 925, 84, 327, 336, 505, 846, 729, 313, 857, 124, 895, 582, 545, 814, 367, 434, 364, 43, 750, 87, 808, 276, 178, 788, 584, 403, 651, 754, 399, 932, 60, 676, 368, 739, 12, 226, 586, 94, 539, 795, 570, 434, 378, 467, 601, 97, 902, 317, 492, 652, 756, 301, 280, 286, 441, 865, 689, 444, 619, 440, 729, 31, 117, 97, 771, 481, 675, 709, 927, 567, 856, 497, 353, 586, 965, 306, 683, 219, 624, 528, 871, 732, 829, 503, 19, 270, 368, 708, 715, 340, 149, 796, 723, 618, 245, 846, 451, 921, 555, 379, 488, 764, 228, 841, 350, 193, 500, 34, 764, 124, 914, 987, 856, 743, 491, 227, 365, 859, 936, 432, 551, 437, 228, 275, 407, 474, 121, 858, 395, 29, 237, 235, 793, 818, 428, 143, 11, 928, 529, 776, 404, 443, 763, 613, 538, 606, 840, 904, 818, 128, 688, 369, 917, 917, 996, 324, 743, 470, 183, 490, 499, 772, 725, 644, 590, 505, 139, 954, 786, 669, 82, 542, 464, 197, 507, 355, 804, 348, 611, 622, 828, 299, 343, 746, 568, 340, 422, 311, 810, 605, 801, 661, 730, 878, 305, 320, 736, 444, 626, 522, 465, 708, 416, 282, 258, 924, 637, 62, 624, 600, 36, 452, 899, 379, 550, 468, 71, 973, 131, 881, 930, 933, 894, 660, 163, 199, 981, 899, 996, 959, 773, 813, 668, 190, 95, 926, 466, 84, 340, 90, 684, 376, 542, 936, 107, 445, 756, 179, 418, 887, 412, 348, 172, 659, 9, 336, 210, 342, 587, 206, 301, 713, 372, 321, 255, 819, 599, 721, 904, 939, 811, 940, 667, 705, 228, 127, 150, 984, 658, 920, 224, 422, 269, 396, 81, 630, 84, 292, 972, 672, 850, 625, 385, 222, 299, 640, 42, 898, 713, 298, 190, 524, 590, 209, 581, 819, 336, 732, 155, 994, 4, 379, 769, 273, 776, 850, 255, 860, 142, 579, 884, 993, 205, 621, 567, 504, 613, 961, 754, 326, 259, 944, 202, 202, 506, 784, 21, 842, 868, 528, 189, 872, 908, 958, 498, 36, 808, 753, 248, 303, 333, 133, 648, 890, 754, 567, 746, 368, 529, 500, 46, 788, 797, 249, 990, 303, 33, 363, 497, 253, 892, 686, 125, 152, 996, 975, 188, 157, 729, 436, 460, 414, 921, 460, 304, 28, 27, 50, 748, 556, 902, 794, 697, 699, 43, 39, 2, 428, 403, 500, 681, 647, 538, 159, 151, 535, 134, 339, 692, 215, 127, 504, 629, 49, 964, 285, 429, 343, 335, 177, 900, 238, 971, 949, 289, 367, 988, 292, 795, 743, 144, 829, 390, 682, 340, 541, 569, 826, 232, 261, 42, 360, 117, 23, 761, 81, 309, 190, 425, 996, 367, 67};

        for (int i = 0; i < arr.length; i++) {
            test.Insert(arr[i]);
            Double val = test.GetMedian();
            System.out.println(val);
        }

//        test.Insert(1);
//        System.out.println(test.GetMedian());
//        test.Insert(1);
//        System.out.println(test.GetMedian());
//        test.Insert(1);
//        System.out.println(test.GetMedian());
//        test.Insert(4);
//        System.out.println(test.GetMedian());
//        test.Insert(1);
//        System.out.println(test.GetMedian());
//        test.Insert(6);
//        System.out.println(test.GetMedian());
//        test.Insert(7);
//        System.out.println(test.GetMedian());
//        test.Insert(0);
//        System.out.println(test.GetMedian());
//        test.Insert(8);
//        System.out.println(test.GetMedian());
    }

//    public static void main(String[] args) {
//        double a = (double) 4;
//        Double
//    }

}
