# 1. 결과물을 담고 있을 primeSet 정의
prime_set = set()


def isPrime(number):
    # 6. 0과 1은 False
    if number in (0, 1):
        return False

    # 7. 에라토스테네스의 체
    lim = int(number ** 0.5 + 1)
    for i in range(2, lim):
        if number % i == 0:
            return False

    return True


def makeCombinations(combination, others):
    # 5. 탈출 조건 / 비교 조건 : 지금까지 만들어진 조합을 
    if combination != "":
        if isPrime(int(combination)):
            prime_set.add(int(combination))

    # 4. 현재까지 만들어진 숫자에, 남아있는 숫자 중 하나를 붙여서 조합을 만든다
    for i in range(len(others)):
        makeCombinations(combination + others[i], others[:i] + others[i + 1:])


def solution(numbers):
    # 2. 모든 조합을 만드는 recursive 함수를 수행한다.
    makeCombinations("", numbers)

    # 3. primeSet의 length를 반환해준다.
    answer = len(prime_set)
    return answer