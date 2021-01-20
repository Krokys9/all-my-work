	.file	"file.c"
	.globl	_saveCount
	.bss
	.align 4
_saveCount:
	.space 4
	.globl	_loadCount
	.align 4
_loadCount:
	.space 4
	.section .rdata,"dr"
LC0:
	.ascii "wb\0"
	.text
	.globl	_saveToFile
	.def	_saveToFile;	.scl	2;	.type	32;	.endef
_saveToFile:
	pushl	%ebp
	movl	%esp, %ebp
	subl	$40, %esp
	movl	_saveCount, %eax
	addl	$1, %eax
	movl	%eax, _saveCount
	movl	$LC0, 4(%esp)
	movl	16(%ebp), %eax
	movl	%eax, (%esp)
	call	_fopen
	movl	%eax, -12(%ebp)
	movl	$0, 8(%esp)
	movl	$0, 4(%esp)
	movl	-12(%ebp), %eax
	movl	%eax, (%esp)
	call	_fseek
	movl	-12(%ebp), %eax
	movl	%eax, 12(%esp)
	movl	$1, 8(%esp)
	movl	$4, 4(%esp)
	leal	12(%ebp), %eax
	movl	%eax, (%esp)
	call	_fwrite
	movl	12(%ebp), %eax
	movl	%eax, %edx
	movl	-12(%ebp), %eax
	movl	%eax, 12(%esp)
	movl	%edx, 8(%esp)
	movl	$4, 4(%esp)
	movl	8(%ebp), %eax
	movl	%eax, (%esp)
	call	_fwrite
	movl	-12(%ebp), %eax
	movl	%eax, (%esp)
	call	_fclose
	movl	-12(%ebp), %eax
	movl	%eax, (%esp)
	call	_fflush
	leave
	ret
	.section .rdata,"dr"
LC1:
	.ascii "rb\0"
	.text
	.globl	_loadFromFile
	.def	_loadFromFile;	.scl	2;	.type	32;	.endef
_loadFromFile:
	pushl	%ebp
	movl	%esp, %ebp
	subl	$40, %esp
	movl	_loadCount, %eax
	addl	$1, %eax
	movl	%eax, _loadCount
	movl	$LC1, 4(%esp)
	movl	8(%ebp), %eax
	movl	%eax, (%esp)
	call	_fopen
	movl	%eax, -12(%ebp)
	movl	$0, 8(%esp)
	movl	$0, 4(%esp)
	movl	-12(%ebp), %eax
	movl	%eax, (%esp)
	call	_fseek
	movl	-12(%ebp), %eax
	movl	%eax, 12(%esp)
	movl	$1, 8(%esp)
	movl	$4, 4(%esp)
	leal	-20(%ebp), %eax
	movl	%eax, (%esp)
	call	_fread
	movl	-20(%ebp), %eax
	addl	$1, %eax
	sall	$2, %eax
	movl	%eax, (%esp)
	call	_malloc
	movl	%eax, -16(%ebp)
	movl	-20(%ebp), %eax
	movl	%eax, %edx
	movl	-12(%ebp), %eax
	movl	%eax, 12(%esp)
	movl	%edx, 8(%esp)
	movl	$4, 4(%esp)
	movl	-16(%ebp), %eax
	movl	%eax, (%esp)
	call	_fread
	movl	-12(%ebp), %eax
	movl	%eax, (%esp)
	call	_fclose
	movl	-12(%ebp), %eax
	movl	%eax, (%esp)
	call	_fflush
	movl	-16(%ebp), %eax
	leave
	ret
	.ident	"GCC: (tdm-1) 4.9.2"
	.def	_fopen;	.scl	2;	.type	32;	.endef
	.def	_fseek;	.scl	2;	.type	32;	.endef
	.def	_fwrite;	.scl	2;	.type	32;	.endef
	.def	_fclose;	.scl	2;	.type	32;	.endef
	.def	_fflush;	.scl	2;	.type	32;	.endef
	.def	_fread;	.scl	2;	.type	32;	.endef
	.def	_malloc;	.scl	2;	.type	32;	.endef
