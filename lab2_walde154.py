class Zillion:

    def __init__(self,digits):
        self.digits = digits
        workingdigit = []
        digits = digits.replace(' ','')
        digits = digits.replace(',','')
        if digits.isdigit():
            for item in digits:
                workingdigit.append(int(item))
            self.digits = workingdigit
        else:
            raise RuntimeError

    def toString(self):
        answer = ''
        for item in self.digits:
            answer += str(item)
        return answer

    def isZero(self):
        for item in self.digits:
            if item != 0:
                return False
            else:
                return True

    def increment(self):
        flag = False
        while flag == False:
            for item in range(-1,(len(self.digits)*-1)-1,-1):

                if (self.digits[item] + 1) < 10:

                    self.digits[item] += 1
                    flag = True
                    break
                elif (len(self.digits)*-1) == item:
                    self.digits[0] = 1
                    self.digits.append(0)
                    flag = True
                    break
                else: #(self.digits[item] + 1) == 10:
                    self.digits[item] = 0


