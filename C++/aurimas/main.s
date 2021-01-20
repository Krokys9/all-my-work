	.file	"main.c"
	.comm	_saveCount, 4, 2
	.comm	_loadCount, 4, 2
	.text
	.globl	_fillArray
	.def	_fillArray;	.scl	2;	.type	32;	.endef
_fillArray:
	pushl	%ebp
	movl	%esp, %ebp
	pushl	%ebx
	subl	$20, %esp
	movl	$0, -12(%ebp)
	movl	$0, -12(%ebp)
	jmp	L2
L3:
	movl	-12(%ebp), %eax
	leal	0(,%eax,4), %edx
	movl	8(%ebp), %eax
	leal	(%edx,%eax), %ebx
	call	_rand
	cltd
	idivl	12(%ebp)
	movl	%edx, %eax
	movl	%eax, (%ebx)
	addl	$1, -12(%ebp)
L2:
	movl	-12(%ebp), %eax
	cmpl	16(%ebp), %eax
	jl	L3
	addl	$20, %esp
	popl	%ebx
	popl	%ebp
	ret
	.section .rdata,"dr"
LC0:
	.ascii "%d  \0"
	.text
	.globl	_printArray
	.def	_printArray;	.scl	2;	.type	32;	.endef
_printArray:
	pushl	%ebp
	movl	%esp, %ebp
	subl	$40, %esp
	movl	$0, -12(%ebp)
	movl	$0, -12(%ebp)
	jmp	L5
L6:
	movl	-12(%ebp), %eax
	leal	0(,%eax,4), %edx
	movl	8(%ebp), %eax
	addl	%edx, %eax
	movl	(%eax), %eax
	movl	%eax, 4(%esp)
	movl	$LC0, (%esp)
	call	_printf
	addl	$1, -12(%ebp)
L5:
	movl	-12(%ebp), %eax
	cmpl	12(%ebp), %eax
	jl	L6
	movl	$10, (%esp)
	call	_putchar
	leave
	ret
	.def	___main;	.scl	2;	.type	32;	.endef
	.section .rdata,"dr"
LC1:
	.ascii "f1.txt\0"
LC2:
	.ascii "something wrong\12 \0"
LC3:
	.ascii "%d    %d   \0"
LC4:
	.ascii "all good\0"
LC5:
	.ascii "antra uzduotis : \12 \0"
LC6:
	.ascii "f2.txt\0"
LC7:
	.ascii "f3.txt\0"
LC8:
	.ascii "%d <- save count\12\0"
LC9:
	.ascii "%d <- loadcount\0"
LC10:
	.ascii "something wrong\0"
	.text
	.globl	_main
	.def	_main;	.scl	2;	.type	32;	.endef
_main:
	pushl	%ebp
	movl	%esp, %ebp
	andl	$-16, %esp
	subl	$48, %esp
	call	___main
	movl	$0, 44(%esp)
	movl	$0, (%esp)
	call	_time
	movl	%eax, (%esp)
	call	_srand
	movl	$10, 36(%esp)
	movl	$10, 32(%esp)
	movl	32(%esp), %eax
	sall	$2, %eax
	movl	%eax, (%esp)
	call	_malloc
	movl	%eax, 28(%esp)
	movl	32(%esp), %eax
	movl	%eax, 8(%esp)
	movl	36(%esp), %eax
	movl	%eax, 4(%esp)
	movl	28(%esp), %eax
	movl	%eax, (%esp)
	call	_fillArray
	movl	32(%esp), %eax
	movl	%eax, 4(%esp)
	movl	28(%esp), %eax
	movl	%eax, (%esp)
	call	_printArray
	movl	$LC1, 8(%esp)
	movl	32(%esp), %eax
	movl	%eax, 4(%esp)
	movl	28(%esp), %eax
	movl	%eax, (%esp)
	call	_saveToFile
	movl	$LC1, (%esp)
	call	_loadFromFile
	movl	%eax, 24(%esp)
	movl	32(%esp), %eax
	movl	%eax, 4(%esp)
	movl	24(%esp), %eax
	movl	%eax, (%esp)
	call	_printArray
	movl	$0, 44(%esp)
	jmp	L8
L11:
	movl	44(%esp), %eax
	leal	0(,%eax,4), %edx
	movl	24(%esp), %eax
	addl	%edx, %eax
	movl	(%eax), %edx
	movl	44(%esp), %eax
	leal	0(,%eax,4), %ecx
	movl	28(%esp), %eax
	addl	%ecx, %eax
	movl	(%eax), %eax
	cmpl	%eax, %edx
	je	L9
	movl	$LC2, (%esp)
	call	_printf
	movl	44(%esp), %eax
	leal	0(,%eax,4), %edx
	movl	28(%esp), %eax
	addl	%edx, %eax
	movl	(%eax), %edx
	movl	44(%esp), %eax
	leal	0(,%eax,4), %ecx
	movl	24(%esp), %eax
	addl	%ecx, %eax
	movl	(%eax), %eax
	movl	%edx, 8(%esp)
	movl	%eax, 4(%esp)
	movl	$LC3, (%esp)
	call	_printf
	jmp	L10
L9:
	movl	$1, 40(%esp)
	addl	$1, 44(%esp)
L8:
	movl	44(%esp), %eax
	cmpl	32(%esp), %eax
	jl	L11
L10:
	cmpl	$1, 40(%esp)
	jne	L12
	movl	$LC4, (%esp)
	call	_puts
L12:
	movl	$LC5, (%esp)
	call	_puts
	movl	$0, _saveCount
	movl	$0, _loadCount
	movl	32(%esp), %eax
	sall	$2, %eax
	movl	%eax, (%esp)
	call	_malloc
	movl	%eax, 24(%esp)
	movl	32(%esp), %eax
	sall	$2, %eax
	movl	%eax, (%esp)
	call	_malloc
	movl	%eax, 20(%esp)
	movl	32(%esp), %eax
	movl	%eax, 8(%esp)
	movl	36(%esp), %eax
	movl	%eax, 4(%esp)
	movl	28(%esp), %eax
	movl	%eax, (%esp)
	call	_fillArray
	movl	32(%esp), %eax
	movl	%eax, 8(%esp)
	movl	36(%esp), %eax
	movl	%eax, 4(%esp)
	movl	24(%esp), %eax
	movl	%eax, (%esp)
	call	_fillArray
	movl	32(%esp), %eax
	movl	%eax, 8(%esp)
	movl	36(%esp), %eax
	movl	%eax, 4(%esp)
	movl	20(%esp), %eax
	movl	%eax, (%esp)
	call	_fillArray
	movl	$LC6, 8(%esp)
	movl	32(%esp), %eax
	movl	%eax, 4(%esp)
	movl	28(%esp), %eax
	movl	%eax, (%esp)
	call	_saveToFile
	movl	$LC6, 8(%esp)
	movl	32(%esp), %eax
	movl	%eax, 4(%esp)
	movl	20(%esp), %eax
	movl	%eax, (%esp)
	call	_saveToFile
	movl	$LC6, (%esp)
	call	_loadFromFile
	movl	%eax, 28(%esp)
	movl	$LC7, 8(%esp)
	movl	32(%esp), %eax
	movl	%eax, 4(%esp)
	movl	24(%esp), %eax
	movl	%eax, (%esp)
	call	_saveToFile
	movl	$LC7, (%esp)
	call	_loadFromFile
	movl	%eax, 20(%esp)
	movl	$LC6, (%esp)
	call	_loadFromFile
	movl	%eax, 24(%esp)
	movl	_saveCount, %eax
	cmpl	$3, %eax
	jne	L13
	movl	_loadCount, %eax
	cmpl	$3, %eax
	jne	L13
	movl	$LC4, (%esp)
	call	_puts
	movl	_saveCount, %eax
	movl	%eax, 4(%esp)
	movl	$LC8, (%esp)
	call	_printf
	movl	_loadCount, %eax
	movl	%eax, 4(%esp)
	movl	$LC9, (%esp)
	call	_printf
	jmp	L14
L13:
	movl	$LC10, (%esp)
	call	_printf
L14:
	movl	$15, %eax
	leave
	ret
	.ident	"GCC: (tdm-1) 4.9.2"
	.def	_rand;	.scl	2;	.type	32;	.endef
	.def	_printf;	.scl	2;	.type	32;	.endef
	.def	_putchar;	.scl	2;	.type	32;	.endef
	.def	_time;	.scl	2;	.type	32;	.endef
	.def	_srand;	.scl	2;	.type	32;	.endef
	.def	_malloc;	.scl	2;	.type	32;	.endef
	.def	_saveToFile;	.scl	2;	.type	32;	.endef
	.def	_loadFromFile;	.scl	2;	.type	32;	.endef
	.def	_puts;	.scl	2;	.type	32;	.endef
