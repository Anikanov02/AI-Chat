FROM ollama/ollama

RUN ollama run deepseek-coder && \
    ollama run deepseek-v3 && \
    ollama run deepseek-r1

CMD ["ollama", "serve"]