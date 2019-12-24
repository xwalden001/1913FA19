def left(e):
    return e[0]
def op(e):
    return e[1]
def right(e):
    return e[2]


def isInside(variable,equation):
    if type(equation) == type(()):
        return isInside(variable,left(equation)) or isInside(variable,right(equation))
    else:
        return variable == equation

def solve(variable,equation):
    if isInside(variable,left(equation)):
        return solving(variable,equation)
    elif isInside(variable,right(equation)):
        newe = (right(equation),op(equation),left(equation))
        if isInside(variable,left(equation)):
            return solvingAdd(variable,equation)
    else:
        return None

def solving(variable,equation):
    if left(equation) == variable:
        return equation
    elif op(left(equation)) == '+':
        return solvingAdd(variable,equation)
    elif op(left(equation)) == '-':
        return solvingSubtract(variable,equation)
    elif op(left(equation)) == '*':
        return solvingMultiply(variable,equation)
    elif op(left(equation)) == '/':
        return solvingDivide(variable,equation)
    return None

def solvingAdd(variable,equation):
    tu = '-',
    goal = variable,
    for item in range(0,(len(left(equation))),1):
        if left(equation)[item] != variable and left(equation)[item] != '+':

            tu = tu + (left(equation)[item],)
    tu = (tuple(right(equation))+tu)
    tu = (variable,op(equation),tu)
    return tu

def solvingSubtract(variable, equation):
    tu = ()
    idx = left(equation).index('-')
    if left(equation)[idx-1] == variable:
        tu = (variable,'=',(right(equation),'+',right(left(equation))))
        return tu
    if left(equation)[idx+1] == variable:
        tu = (variable, '=', (left(left(equation)), '-', right(equation)))
        return tu

def solvingMultiply(variable,equation):
    tu = '/',
    goal = variable,
    for item in range(0, (len(left(equation))), 1):
        if left(equation)[item] != variable and left(equation)[item] != '*':
            tu = tu + (left(equation)[item],)
    tu = (tuple(right(equation)) + tu)
    tu = (variable, op(equation), tu)
    return tu

def solvingDivide(variable,equation):
    tu = ()
    idx = left(equation).index('/')
    if left(equation)[idx - 1] == variable:
        tu = (variable, '=', (right(equation), '*', right(left(equation))))
        return tu
    if left(equation)[idx + 1] == variable:
        tu = (variable, '=', (left(left(equation)), '/', right(equation)))
        return tu


