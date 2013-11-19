set nocompatible

set ruler
set showcmd
set bg=dark
set number
syntax on
set hlsearch
set incsearch
set cursorline
set tabstop=4

" Settings against MiniBuffer plugin

 
" Settings against the NERDTree plugin
let NERDTreeShowHidden=1
let NERDTreeWinSize=30
nmap <silent> nerd :NERDTreeToggle<cr>

" Settings against the WinManager plugin
let g:winManagerWidth = 30
let g:AutoOpenWinManager = 1

let g:NERDTree_title="[NERDTree]"  
let g:winManagerWindowLayout = 'FileExplorer,BufExplorer'
"let g:winManagerWindowLayout="NERDTree"  
function! NERDTree_Start()  
    exec 'NERDTreeToggle'  
endfunction  
function! NERDTree_IsValid()  
    return 1  
endfunction  

nmap <silent> wm :WMToggle<cr>

" Settings against Netrw plugin
let g:netrw_banner=0
let g:netrw_preview=1
let g:netrw_liststyle=3
let g:netrw_winsize=30
let g:netrw_browse_split=2
