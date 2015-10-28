public List<List<Integer>> threeSum(int[] nums) {
//        int length = nums.length;
//        int a,b,c,target;
//        List<List<Integer>> answer;
//        answer = new ArrayList<List<Integer>>();
//        Set<String> temp = new HashSet<String>();
//        /*for(int i = 0; i < length; i++)
//        	for(int j = i + 1; j < length; j++)
//        	{
//        		a = nums[i];
//        		b = nums[j];
//        		target = 0 - a - b;
//        	}
//        	*/
//        //Arrays.sort(nums);
//        for(int i = 0; i < length; i++)
//        {
//        	//if(i + 1 < length && nums[i] == nums[i + 1])
//        	//	continue;
//        	a = nums[i];
//        	target = 0 - a;
//        	HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
//        	for(int j = i + 1; j < length - 1; j++)
//        	{
//        		/*if(j + 1 < length && nums[j] == nums[j + 1])
//        		{
//        			//i = j + 1;
//        			continue;
//        		}
//        		*/
//        		//if(nums[j] == nums[i])
//        		//	i = j;
//        		if(!map.containsKey(nums[j]))
//        			map.put(target - nums[j], nums[j]);
//        		else
//        		{
//        			b = nums[j];
//        			c = (int)map.get(nums[j]);
//        			//List<Integer> list = new ArrayList<Integer>();
//        			String x;
//        			if(a <= b && a <= c)
//        			{
//        				//list.add(a);
//        				if(b <= c)
//        				{
//        					//list.add(b);
//        					//list.add(c);
//        					x = "" + a + ',' + b + ',' + c ;
//        				}
//        				else
//        				{
//        					//list.add(c);
//        					//list.add(b);
//        					x = "" + a + ',' + c + ',' + b ;
//        				}
//        			}
//        			else if(b <= a && b <= c)
//        			{
//        				//list.add(b);
//        				if(a <= c)
//        				{
//        					//list.add(a);
//        					//list.add(c);
//        					x = "" + b + ',' + a + ',' + c ;
//        				}
//        				else
//        				{
//        					//list.add(c);
//        					//list.add(a);
//        					x = "" + b + ',' + c + ',' + a ;
//        				}
//        			}
//        			else
//        			{
//        				//list.add(c);
//        				if(a <= b)
//        				{
//        					//list.add(a);
//        					//list.add(b);
//        					x = "" + c + ',' + a + ',' + b ;
//        				}
//        				else
//        				{
//        					//list.add(b);
//        					//list.add(a);
//        					x = "" + c + ',' + b + ',' + a ;
//        				}
//        			}
//        			temp.add(x);
//        			//answer.add(list);
//        		}
//        	}
//        }
//        Iterator<String> iter = temp.iterator();
//        while(iter.hasNext())
//        {
//        	String x = iter.next();
//        	String[] result = x.split(",");
//        	List<Integer> list = new ArrayList<Integer>();
//        	list.add(Integer.parseInt(result[0]));
//        	list.add(Integer.parseInt(result[1]));
//        	list.add(Integer.parseInt(result[2]));
//        	answer.add(list);
//        }
//        return answer;
		
//		int length = nums.length;
//		int a,target;
//		List<List<Integer>> answer = new ArrayList<List<Integer>>();
//		Arrays.sort(nums);
//		for(int i = 0; i < length; i++)
//		{
//			a = nums[i];
//			target = 0 - a;
//			HashMap<String,Boolean> exist = new HashMap<String,Boolean>();
//			HashMap<Integer,Integer> find = new HashMap<Integer,Integer>();
//			List<Integer> newlist = new ArrayList<Integer>();
//			for(int j = i + 1; j < length; j++)
//			{
//				if(!find.containsKey(nums[j]))
//					find.put(target - nums[j], nums[j]);
//				else
//				{
//					newlist.add(a);
//					newlist.add(nums[j]);
//					newlist.add(target - nums[j]);
//					Collections.sort(newlist);
//					String x = "" + newlist.get(0) + ',' + newlist.get(1) + ',' + newlist.get(2);
//					if(!exist.containsKey(x))
//					{
//						exist.put(x, true);
//						answer.add(newlist);
//						newlist = null;
//					}
//				}
//			}
//		}
//		return answer;
		
		int length = nums.length;
		int a,target;
		Arrays.sort(nums);
		List<List<Integer>> answer = new ArrayList<List<Integer>>();
		List<Integer> newlist;
		for(int i = 0; i < length; i++)
		{
			a = nums[i];
			target = 0 - a;
			int left = i + 1;
			int right = length - 1;
			while(left < right)
			{
				if(nums[left] + nums[right] == target)
				{
					newlist = new ArrayList<Integer>();
					newlist.add(a);
					newlist.add(nums[left]);
					newlist.add(nums[right]);
					answer.add(newlist);
					if(nums[left] == nums[right])
						break;
					else
					{
						//while(nums[left] == nums[left + 1] && left + 1 < length)
						while(left + 1 < length && nums[left] == nums[left + 1])
							left++;
						//while(nums[right] == nums[right - 1] && right - 1 > i)
						while(right - 1 > i && nums[right] == nums[right - 1])
							right--;
					}
					left++;
					right--;
				}
				else if(nums[left] + nums[right] > target)
					right--;
				else
					left++;
				
			}
			//while(nums[i] == nums[i + 1] && i + 1 < length)
			while(i + 1 < length && nums[i] == nums[i + 1])
				i++;
		}
		return answer;
    }