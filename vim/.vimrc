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

" Settings against Netrw plugin
let g:netrw_banner=0
let g:netrw_preview=1
let g:netrw_liststyle=3
let g:netrw_winsize=30
let g:netrw_browse_split=2
