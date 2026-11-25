package ua.opnu;

import java.util.*;

public class Task
{
    public static void main(String[] args)
    {

    }

    public void removeShorterStrings(List<String> list)
    {
        for (int i = 0; i < list.size() - 1; i++)
        {
            if (list.get(i).length() <= list.get(i + 1).length())
            {
                list.remove(i);
            }
            else
            {
                list.remove(i + 1);
            }
        }
    }

    public void stutter(List<String> list)
    {
        for (int i = 0; i < list.size(); i += 2)
        {
            list.add(i, list.get(i));
        }
    }

    public void switchPairs(List<String> list)
    {
        for (int i = 0; i < list.size() - 1; i += 2)
        {
            String temp = list.get(i);
            list.set(i, list.get(i + 1));
            list.set(i + 1, temp);
        }
    }

    public void removeDuplicates(List<String> list)
    {
        int i = 0;
        while (i < list.size() - 1)
        {
            if (Objects.equals(list.get(i), list.get(i + 1)))
            {
                list.remove(i + 1);
            }
            else
            {
                i++;
            }
        }
    }

    public void markLength4(List<String> list)
    {
        for (int i = 0; i < list.size(); i++)
        {
            if (list.get(i).length() == 4)
            {
                list.add(i, "****");
                i++;
            }
        }
    }

    public boolean isPalindrome(Queue<Integer> queue)
    {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int size = queue.size();

        for (int i = 0; i < size; i++)
        {
            Integer val = queue.poll();
            queue.offer(val);
            stack.push(val);
        }

        boolean palindrome = true;
        for (int i = 0; i < size; i++)
        {
            Integer val = queue.poll();
            if (!Objects.equals(val, stack.pop()))
            {
                palindrome = false;
            }
            queue.offer(val);
        }

        return palindrome;
    }

    public void reorder(Queue<Integer> queue)
    {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int size = queue.size();
        int nonNegativeCount = 0;

        for (int i = 0; i < size; i++)
        {
            Integer val = queue.poll();
            if (val < 0)
            {
                stack.push(val);
            }
            else
            {
                queue.offer(val);
                nonNegativeCount++;
            }
        }

        while (!stack.isEmpty())
        {
            queue.offer(stack.pop());
        }

        for (int i = 0; i < nonNegativeCount; i++)
        {
            queue.offer(queue.poll());
        }
    }

    public void rearrange(Queue<Integer> queue)
    {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int size = queue.size();

        for (int pass = 0; pass < 2; pass++)
        {
            for (int i = 0; i < size; i++)
            {
                Integer val = queue.poll();
                if (val % 2 == 0)
                {
                    queue.offer(val);
                }
                else
                {
                    stack.push(val);
                }
            }
            while (!stack.isEmpty())
            {
                queue.offer(stack.pop());
            }
        }
    }

    public int maxLength(Set<String> set)
    {
        int max = 0;
        for (String s : set)
        {
            if (s.length() > max)
            {
                max = s.length();
            }
        }
        return max;
    }

    public void removeEvenLength(Set<String> set)
    {
        if (set.isEmpty())
        {
            return;
        }
        set.removeIf(s -> s.length() % 2 == 0);
    }

    public int numInCommon(List<Integer> list1, List<Integer> list2)
    {
        Set<Integer> common = new HashSet<>(list1);
        common.retainAll(new HashSet<>(list2));
        return common.size();
    }

    public boolean isUnique(Map<String, String> map)
    {
        Set<String> seenValues = new HashSet<>();
        for (String value : map.values())
        {
            if (!seenValues.add(value))
            {
                return false;
            }
        }
        return true;
    }

    public Map<String, Integer> intersect(Map<String, Integer> map1, Map<String, Integer> map2)
    {
        Map<String, Integer> result = new HashMap<>();
        for (Map.Entry<String, Integer> entry : map1.entrySet())
        {
            String key = entry.getKey();
            if (map2.containsKey(key) && Objects.equals(entry.getValue(), map2.get(key)))
            {
                result.put(key, entry.getValue());
            }
        }
        return result;
    }

    public Map<String, Integer> reverse(Map<Integer, String> map)
    {
        Map<String, Integer> reversed = new HashMap<>();
        for (Map.Entry<Integer, String> entry : map.entrySet())
        {
            reversed.merge(entry.getValue(), entry.getKey(), Math::max);
        }
        return reversed;
    }

    public int rarest(Map<String, Integer> map)
    {
        if (map.isEmpty())
        {
            return 0;
        }

        Map<Integer, Integer> frequencies = new HashMap<>();
        for (Integer value : map.values())
        {
            frequencies.put(value, frequencies.getOrDefault(value, 0) + 1);
        }

        int minFreq = Integer.MAX_VALUE;
        int rarestValue = Integer.MAX_VALUE;

        for (Map.Entry<Integer, Integer> entry : frequencies.entrySet())
        {
            int value = entry.getKey();
            int freq = entry.getValue();

            if (freq < minFreq || (freq == minFreq && value < rarestValue))
            {
                minFreq = freq;
                rarestValue = value;
            }
        }

        return rarestValue;
    }

    public int maxOccurrences(List<Integer> list)
    {
        if (list.isEmpty())
        {
            return 0;
        }

        Map<Integer, Integer> counts = new HashMap<>();
        int maxCount = 0;

        for (Integer num : list)
        {
            int updated = counts.getOrDefault(num, 0) + 1;
            counts.put(num, updated);
            if (updated > maxCount)
            {
                maxCount = updated;
            }
        }

        return maxCount;
    }
}