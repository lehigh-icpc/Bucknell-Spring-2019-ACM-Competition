def right(board, pos):
	invalid = [2, 3, 5, 6, 12, 13, 19, 20, 26, 27, 29, 30, 32, 33]
	if pos in invalid:
		return 0, 0
	if board[pos] == 1 and board[pos + 1] == 1 and board[pos + 2] == 0:
		return pos + 1, pos + 2
	else:
		return 0, 0


def left(board, pos):
	invalid = [1, 2, 4, 5, 7, 8, 14, 15, 21, 22, 28, 29, 31, 32]
	if pos in invalid:
		return 0, 0
	if board[pos] == 1 and board[pos - 1] == 1 and board[pos - 2] == 0:
		return pos - 1, pos - 2
	else:
		return 0, 0


def up(board, pos):
	invalid = [1, 2, 3, 4, 5, 6, 7, 8, 14, 15, 12, 13, 19, 20]
	if pos in invalid:
		return 0, 0
	if pos >= 9 and pos <= 11:
		if board[pos] == 1 and board[pos - 5] == 1 and board[pos - 8] == 0:
			return pos - 5, pos - 8
		else:
			return 0, 0
	elif (pos >= 16 and pos <= 18):
		if board[pos] == 1 and board[pos - 7] == 1 and board[pos - 12] == 0:
			return pos - 7, pos - 12
		else:
			return 0, 0
	elif pos >= 21 and pos <= 27:
		if board[pos] == 1 and board[pos - 7] == 1 and board[pos - 14] == 0:
			return pos - 7, pos - 14
		else:
			return 0, 0
	elif pos >= 28 and pos <= 30:
		if board[pos] == 1 and board[pos - 5] == 1 and board[pos - 12] == 0:
			return pos - 5, pos - 12
		else:
			return 0, 0
	elif pos >= 31 and pos <= 33:
		if board[pos] == 1 and board[pos - 3] == 1 and board[pos - 8] == 0:
			return pos - 3, pos - 8
		else:
			return 0, 0


def down(board, pos):
	invalid = [14, 15, 21, 22, 19, 20, 26, 27, 28, 29, 30, 31, 32, 33]
	if pos in invalid:
		return 0, 0
	if pos >= 1 and pos <= 3:
		if board[pos] == 1 and board[pos + 3] == 1 and board[pos + 8] == 0:
			return pos + 3, pos + 8
		else:
			return 0, 0
	elif pos >= 4 and pos <= 6:
		if board[pos] == 1 and board[pos + 5] == 1 and board[pos + 12] == 0:
			return pos + 5, pos + 12
		else:
			return 0, 0
	elif pos >= 7 and pos <= 13:
		if board[pos] == 1 and board[pos + 7] == 1 and board[pos + 14] == 0:
			return pos + 7, pos + 14
		else:
			return 0, 0
	elif pos >= 16 and pos <= 18:
		if board[pos] == 1 and board[pos + 7] == 1 and board[pos + 12] == 0:
			return pos + 7, pos + 12
		else:
			return 0, 0
	elif pos >= 23 and pos <= 25:
		if board[pos] == 1 and board[pos + 5] == 1 and board[pos + 8] == 0:
			return pos + 5, pos + 8
		else:
			return 0, 0

################################# main:

cases = int(input())
for case in range(cases):
	# get input
	pegs = input().split()
	if len(pegs) == 0:
		print(0)
		continue

	# make board
	board = {}
	for i in range(1, 34):
		board[i] = 0
	for i in range(len(pegs)):
		board[int(pegs[i])] = 1

	# make moves
	moved = True
	while moved:
		# find move
		move = ''
		score = 0
		position = 0
		for pos in range(1, 34):
			if board[pos] == 1:
				over, dest = up(board, pos)
				if dest > score:
					position = pos
					score = dest
					move = 'up'
				elif dest == score:
					if pos > position:
						position = pos
						score = dest
						move = 'up'
				over, dest = down(board, pos)
				if dest > score:
					position = pos
					score = dest
					move = 'down'
				elif dest == score:
					if pos > position:
						position = pos
						score = dest
						move = 'down'
				over, dest = left(board, pos)
				if dest > score:
					position = pos
					score = dest
					move = 'left'
				elif dest == score:
					if pos > position:
						position = pos
						score = dest
						move = 'left'
				over, dest = right(board, pos)
				if dest > score:
					position = pos
					score = dest
					move = 'right'
				elif dest == score:
					if pos > position:
						position = pos
						score = dest
						move = 'right'
		
		# make move
		if score > 0:
			if move == 'up':
				over, dest = up(board, position)
			elif move == 'down':
				over, dest = down(board, position)
			elif move == 'left':
				over, dest = left(board, position)
			elif move == 'right':
				over, dest = right(board, position)
			board[position] = 0
			board[over] = 0
			board[dest] = 1
		else:
			moved = False

	# find number of remaining pegs
	num = 0
	for i in range(1, 34):
		if board[i] == 1:
			num += i

	print(num)
