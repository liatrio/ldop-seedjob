folder('sample_pipelines')

samplePipelines = readFileFromWorkspace('sample_pipelines.txt')
samplePipelines.eachLine { line ->
  (repoUrl,branchName) = line.split('#')
  repoName = repoUrl.split('/')[3].split('.')[0]
  pipelineJob("sample_pipelines/${repoName}") {
    scm {
      git {
        remote {
          url(repoUrl)
        }
        branch(branchName)
      }
    }
  }
}

