def snake_sequence_helper(grid, i, j, m, n, down_value_list, right_value_list):

    down_value_list = list()
    down_value_list.append(grid[i][j])

    right_value_list = list()
    right_value_list.append(grid[i][j])
     
    if i + 1 <= m and (grid[i][j] + 1 == grid[i+1][j] 
    or grid[i][j] - 1 == grid[i+1][j]):
        
        to_be_extended = snake_sequence_helper(grid, i + 1, j, m, n, 
        down_value_list, right_value_list)

        down_value_list.extend(to_be_extended)
    
    if j + 1 <= n and (grid[i][j] + 1 == grid[i][j+1] 
    or grid[i][j] - 1 == grid[i][j+1]):
        
        to_be_extended = snake_sequence_helper(grid, i, j + 1, m, n,
        down_value_list, right_value_list)

        right_value_list.extend(to_be_extended)
    
    if sum(down_value_list) >= sum(right_value_list):

        return down_value_list
    
    else:

        return right_value_list
    
def snake_sequence(grid):

    m = len(grid) - 1
    n = len(grid[0]) - 1

    maximum_value_path = 0
    result = list()

    for i in range(len(grid)):
        for j in range(len(grid[i])):

            current_path = snake_sequence_helper(grid, i, j, m, n, [], [])
            current_value_path = sum(current_path)

            if current_value_path > maximum_value_path:

                maximum_value_path = current_value_path
                result = current_path[:] 
    
    return result

result = snake_sequence([[9, 6, 5, 2], [8, 7, 6, 5], [7, 3, 1, 6], [1, 1, 1, 7]])
print(result)

print()

result = snake_sequence([[7, 5, 2, 3, 1], [3, 4, 1, 4, 4], [1, 5, 6, 7, 8], [3, 4, 5, 8, 9], 
[3, 2, 2, 7, 6]])
print(result)


