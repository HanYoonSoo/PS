# def solution(target):
#     target_list = []
    
#     if target > 61:
#         for i in range(target + 1):
#             target_list.append([target, 0])   
#     else:
#         for i in range(61):
#             target_list.append([target, 0])
    
#     target_list[50] = [1, 1]
    
#     for i in range(1, 21):
#         target_list[i] = [1, 1]
    
#     for i in range(1, 21):
#         if target_list[i * 2] == [target, 0]:
#             target_list[i * 2] = [1, 0]
        
#         if target_list[i * 3] == [target, 0]:
#             target_list[i * 3] = [1, 0]
    
#     for cur_target in range(23, len(target_list)):
#         temp = []
#         minValue = min(cur_target, 61)
        
#         for comp_target in range(1, minValue):
#             if target_list[minValue - comp_target][0] + target_list[comp_target][0] <= target_list[cur_target][0]:
#                 target_list[cur_target][0] = target_list[minValue - comp_target][0] + target_list[comp_target][0]
#                 temp.append((target_list[minValue - comp_target][0] + target_list[comp_target][0], target_list[cur_target - comp_target][1] + target_list[comp_target][1]))
#         temp.sort(key = lambda x: (x[0], -x[1]))
        
#         if len(temp) > 0:
#             target_list[cur_target] = temp[0]
    
#     return target_list[target]
        
        
def solution(target):
    # 우선 점수판의 구성을 한다.
    memo_list = [[target, 0] for _ in range(target+1 if target > 61 else 61)]
    memo_list[50] = [1, 1] # 조합수, single or bool 개수
    for i in range(1, 21):
        if 1 <= i <= 20:
            memo_list[i] = [1, 1] # 조합수, single or bool 개수
    for i in range(1, 21):
        if memo_list[i*2] == [target, 0]:
            memo_list[i*2] = [1, 0]
        if memo_list[i*3] == [target, 0]:
            memo_list[i*3] = [1, 0]

    # 60 숫자 이전에 빈 곳을 메꾸고 이후는 다트판 최대가 60 이므로 이전 60까지 탐색하도록 했다.
    for cur_index in range(23, len(memo_list)):
        single_or_bool_candidator = []
        min_index = 61 if cur_index > 61 else cur_index
        for comp_index in range(1, min_index):
            if memo_list[cur_index - comp_index][0] + memo_list[comp_index][0] <= memo_list[cur_index][0]:
                memo_list[cur_index][0] = memo_list[cur_index - comp_index][0] + memo_list[comp_index][0]
                single_or_bool_candidator.append([memo_list[cur_index - comp_index][0] + memo_list[comp_index][0], memo_list[cur_index - comp_index][1] + memo_list[comp_index][1]])
        single_or_bool_candidator.sort(key=lambda x: [x[0], -x[1]])
        if len(single_or_bool_candidator) > 0:
            memo_list[cur_index] = single_or_bool_candidator[0]

    # 끝
    return memo_list[target] 