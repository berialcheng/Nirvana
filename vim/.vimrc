set nocompatible

set ruler
set bg=dark
set number
syntax on
set hlsearch
set cursorline

" Settings against the WinManager plugin
"let g:winManagerWidth = 30
"let g:winManagerWindowLayout = "FileExplorer"
"nmap <silent> wm :WMToggle<cr>

" Settings against the NERDTree plugin 
let NERDTreeShowHidden=1
let NERDTreeWinSize=40
nmap <silent> wm :NERDTreeToggle<cr>
