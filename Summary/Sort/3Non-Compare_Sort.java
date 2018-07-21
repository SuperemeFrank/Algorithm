 // Counting Sort*************************************************************************************************************
    // limit: nums should be >= 0 && < K.  
    // Times: O(n + K), Space: O(n + K)
    // Stable sort
    public static int[] Countingsort(int[] nums, int K){
        int[] Count = new int[K];
        int[] res = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            Count[nums[i]]++;
        }
        for(int i = 1; i < K; i ++){
            Count[i] += Count[i - 1];
        }
        for(int i = nums.length - 1; i >= 0; i--){
            res[Count[nums[i]] - 1] = nums[i];
            Count[nums[i]]--;
        }

        return res;
    }

//Bucket Sort******************************************************************************************************************************
    //limit: should know the boudary of the element
    //Times: O(N + NlogN - NlogM) Space: O(M).   Thus, when M -> N, Times -> O(N), but Space increases.
    //Stable sort
    public static int[] BucketSort(int[] nums, int M, int maxEle, int minEle){
        List<List<Integer>> Buckets = new ArrayList<>();
        List<Integer> listFinal = new ArrayList<>();
        int size = (maxEle - minEle)/M;
        for(int i = 0; i < M; i++){
            Buckets.add(i, new ArrayList<Integer>(size));
        }
        for(int i = 0; i < nums.length; i++){
            for(int m = 0; m < M; m++){
                if(nums[i] < minEle + (m + 1) * size && nums[i] >= minEle + m * size){
                    Buckets.get(m).add(nums[i]);
                }
            }
        }
        for(int i = 0; i < M; i++){
            Collections.sort(Buckets.get(i));
            listFinal.addAll(Buckets.get(i));
        }

        Integer[] a = listFinal.toArray(new Integer[listFinal.size()]);
        int[] intArray = Arrays.stream(a).mapToInt(Integer::intValue).toArray();

        return intArray;
    }