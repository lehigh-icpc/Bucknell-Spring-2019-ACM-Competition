primes = [3, 5, 7, 11, 13, 17, 19, 23, 27, 29, 31]

def next(lists, sequence, used, level, n):
	if level == n:
		if sequence[0] + sequence[n - 1] in primes:
			lists.append(sequence)
	for i in range(2, n + 1):
		if i not in used:
			if sequence[len(sequence) - 1] + i in primes:
				copy = sequence.copy()
				copy.append(i)
				used_copy = used.copy()
				used_copy.append(i)
				next(lists, copy, used_copy, level + 1, n)


while True:
	n = int(input())
	if n == 0:
		break
	if n == 1:
		print(1)
	elif n % 2 == 0:
		lists = []
		next(lists, [1], [1], 1, n)
		for i in lists:
			output = ''
			for j in range(len(i)):
				output += str(i[j])
				if j != len(i) - 1:
					output += ' '
			if output != '':
				print(output)
