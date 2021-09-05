package newcoder.sort;

/**
 * @Auther: 布谷
 * @Date: 2021/8/31 15:15
 * @Description: 归并排序
 */
public class MergeSort {

    public int[] mySort(int[] arr) {
        if(arr == null || arr.length < 2){
            return arr;
        }
        //递归归并排序
//        mergeSort(0,arr.length - 1,arr,new int[arr.length]);
        //非递归归并排序
        mergeSort(arr);
        return arr;
    }

    /**
     * 非递归实现归并排序
     * @param arr
     */
    private void mergeSort(int[] arr){
        //记录数组长度
        int length = arr.length;
        //当前分组长度，从单个元素开始分组
        int occuMergeSize = 1;
        while(occuMergeSize < length){
            //分组长度 > 数组长度结束循环，代表分组已经归并完成
            int left = 0;
            //当前归并长度下，进行循环处理；left表示当前归并分组的左侧index
            while(left < length){
                //mid为当前归并分组的中间元素index
                int mid = left + occuMergeSize - 1;
                if(mid >= length){
                    break;
                }
                //right为当前归并分组右分组的末尾元素index，当最后一组不足分组时，使用数组长度
                int right = Math.min(length - 1,mid + occuMergeSize);
                //对当前分组进行归并操作
                merge(arr,left,right,mid);
                //设置下一组left的index 为 上一组right的index + 1
                left = right + 1;
                //如果分组已经到了一半数组长度，则可以之内中断分组，因为下一次分组，单组长度会超过数组长度
                if(occuMergeSize > length / 2){
                    break;
                }
            }
            occuMergeSize <<= 1;
        }
    }

    /**
     * 归并操作
     * @param arr 数组
     * @param left left左分组的开始位置
     * @param right right 右分组的结束位置
     * @param mid 左右分组的中心位置，偶数的话，靠左
     */
    private void merge(int[] arr,int left,int right,int mid){
        int[] temp = new int[right - left + 1];
        int index = 0;
        int leftStart = left;
        int rightStart = mid + 1;
        //归并时左右分别有序，每次复制左右分组中比较小的元素，防止在temp数组中
        while(leftStart <= mid && rightStart <= right){
            if(arr[leftStart] <= arr[rightStart]){
                temp[index++] = arr[leftStart++];
            }else{
                temp[index++] = arr[rightStart++];
            }
        }
        //当左边分组更长时
        while(leftStart <= mid){
            temp[index++] = arr[leftStart++];
        }
        //当右边分组更长时
        while(rightStart <= right){
            temp[index++] = arr[rightStart++];
        }
        //将排序好的temp数组，替换原来的数组位置
        if(index > 0){
            System.arraycopy(temp, 0, arr, left, index);
        }
    }

    public void mergeSort(int start,int end,int[] arr){
        if(start >= end){
            return ;
        }
        int mid = start + (end - start) / 2;

        mergeSort(start,mid,arr);
        mergeSort(mid + 1,end,arr);
        merge(arr,start,end,mid);
    }

    private void merge(int start,int end,int mid,int[] nums,int[] temp){
        int index = 0;
        int left = start;
        int right = mid + 1;
        while(left <= mid && right <= end){
            if(nums[left] <= nums[right]){
                temp[index++] = nums[left++];
            }else{
                temp[index++] = nums[right++];
            }
        }
        while(left <= mid){
            temp[index++] = nums[left++];
        }
        while(right <= end){
            temp[index++] = nums[right++];
        }
        if(index > 0){
            System.arraycopy(temp, 0, nums, start, index);
        }
    }
}
