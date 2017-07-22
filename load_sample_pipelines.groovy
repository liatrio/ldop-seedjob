folder('sample_pipelines')

samplePipelines = readFileFromWorkspace('sample_pipelines.txt')
samplePipelines.eachLine { line ->
  (repoUrl,branchName) = line.split('#')
  repoName = repoUrl.split('/')[4].split('\\.')[0]
  println(repoName)
  pipelineJob("sample_pipelines/${repoName}") {
    definition {
      cpsScm {
        scm {
          git{
            remote {
              url(repoUrl)
            }
            branch(branchName)
          }
        }
        scriptPath('Jenkinsfile')
      }
    }
  }
}
